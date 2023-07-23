package com.ashu.prop.service.impl;

import com.ashu.prop.entity.PropertyEntity;
import com.ashu.prop.entity.UserEntity;
import com.ashu.prop.exception.ApplicationException;
import com.ashu.prop.exception.PropertyNotFoundException;
import com.ashu.prop.repository.IPropertyRepository;
import com.ashu.prop.converter.PropertyConverter;
import com.ashu.prop.dto.PropertyDTO;
import com.ashu.prop.repository.IUserRepository;
import com.ashu.prop.service.IPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertServiceImpl implements IPropertyService {

    private static final Logger logger = LoggerFactory.getLogger(PropertServiceImpl.class);

    @Value("${ashu.prop:}")
    private String prop;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(propertyDTO.getUserId());
        if(optionalUserEntity.isPresent()) {
            PropertyEntity propertyEntity = propertyConverter.convertPropertyDTOtoPropertyEntity(propertyDTO);
            propertyEntity.setUserEntity(optionalUserEntity.get());
            propertyEntity = propertyRepository.save(propertyEntity);
            propertyDTO = propertyConverter.convertPropertyEntitytoPropertyDTO(propertyEntity);
            return propertyDTO;
        } else {
            throw new ApplicationException("User details not found with ID "+ propertyDTO.getUserId());
        }
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> iterablePropEntity = propertyRepository.findAllByUserEntityId(userId);
        List<PropertyDTO> listOfProperties = new ArrayList<>();
        for (PropertyEntity propertyEntity: iterablePropEntity) {
            PropertyDTO propertyDTO = propertyConverter.convertPropertyEntitytoPropertyDTO(propertyEntity);
            listOfProperties.add(propertyDTO);
        }
        return listOfProperties;
    }


    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> iterablePropEntity = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> listOfProperties = new ArrayList<>();
        for (PropertyEntity propertyEntity: iterablePropEntity) {
            PropertyDTO propertyDTO = propertyConverter.convertPropertyEntitytoPropertyDTO(propertyEntity);
            listOfProperties.add(propertyDTO);
        }
        return listOfProperties;
    }

    @Override
    public PropertyDTO getPropertyByID(Long propertyID) {
        logger.debug("prop: {}", prop);
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        PropertyDTO propertyDTO = null;
        if(propertyEntity.isPresent()) {
            PropertyEntity pe = propertyEntity.get();
            propertyDTO = propertyConverter.convertPropertyEntitytoPropertyDTO(pe);
        } else {
            throw new PropertyNotFoundException("Property with ID " + propertyID + " not found!");
        }
        return propertyDTO;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyID);
        if(propertyEntity.isPresent()) {
            PropertyEntity pe = propertyEntity.get();
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setTitle(propertyDTO.getTitle());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            propertyRepository.save(pe);
            propertyDTO.setId(propertyID);
            return propertyDTO;
        } else {
            return null;
        }
    }

}