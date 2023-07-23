package com.ashu.prop.service;

import com.ashu.prop.dto.PropertyDTO;
import com.ashu.prop.exception.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IPropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllProperties();

    PropertyDTO getPropertyByID(Long propertyID);

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID);
}
