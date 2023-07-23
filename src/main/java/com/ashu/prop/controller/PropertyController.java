package com.ashu.prop.controller;

import com.ashu.prop.dto.PropertyDTO;
import com.ashu.prop.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> listOfProperties = propertyService.getAllProperties();
        return new ResponseEntity<List<PropertyDTO>>(listOfProperties, HttpStatus.OK);
    }

    @GetMapping("/property/{propertyID}")
    public ResponseEntity<PropertyDTO> getProperty(@PathVariable Long propertyID) {
        PropertyDTO propertyDTO = propertyService.getPropertyByID(propertyID);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
    }


    @PutMapping("/properties/{propertyID}")
    public ResponseEntity<Object> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyID) {
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyID);
        if(propertyDTO != null) {
            return new ResponseEntity<Object>(propertyDTO, HttpStatus.OK);
        }else{
            String strMessage = "Property not found with Id: " + propertyID;
            return new ResponseEntity<Object>(strMessage, HttpStatus.OK);
        }
    }
}