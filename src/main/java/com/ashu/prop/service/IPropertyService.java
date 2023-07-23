package com.ashu.prop.service;

import com.ashu.prop.dto.PropertyDTO;

import java.util.List;
public interface IPropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllPropertiesForUser(Long userId);

    List<PropertyDTO> getAllProperties();

    PropertyDTO getPropertyByID(Long propertyID);

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID);
}
