package com.ashu.prop.service.impl;

import com.ashu.prop.entity.PropertyEntity;
import com.ashu.prop.repository.IPropertyRepository;
import com.ashu.prop.converter.PropertyConverter;
import com.ashu.prop.dto.PropertyDTO;
import com.ashu.prop.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertServiceImpl implements IPropertyService {

    @Value("${ashu.prop:}")
    private String prop;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
         PropertyEntity propertyEntity = propertyConverter.convertPropertyDTOtoPropertyEntity(propertyDTO);
         propertyEntity = propertyRepository.save(propertyEntity);
         propertyDTO =  propertyConverter.convertPropertyEntitytoPropertyDTO(propertyEntity);
         return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("prop:" + prop);
        List<PropertyEntity> iterablePropEntity = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> listOfProperties = new ArrayList<PropertyDTO>();
        for (PropertyEntity propertyEntity: iterablePropEntity) {
            PropertyDTO propertyDTO = propertyConverter.convertPropertyEntitytoPropertyDTO(propertyEntity);
            listOfProperties.add(propertyDTO);
        }
        return listOfProperties;
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