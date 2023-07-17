package com.ashu.prop.service;

import com.ashu.prop.dto.PropertyDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IPropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);

    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID);
}
