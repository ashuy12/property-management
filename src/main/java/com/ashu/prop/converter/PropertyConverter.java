package com.ashu.prop.converter;

import com.ashu.prop.entity.PropertyEntity;
import com.ashu.prop.dto.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertPropertyDTOtoPropertyEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        return propertyEntity;
    }

    public PropertyDTO convertPropertyEntitytoPropertyDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        return propertyDTO;
    }

}
