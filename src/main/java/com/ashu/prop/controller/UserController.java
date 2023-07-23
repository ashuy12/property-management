package com.ashu.prop.controller;

import com.ashu.prop.dto.UserDTO;
import com.ashu.prop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> resisterUser(@RequestBody UserDTO userDTO) {
        userDTO = userService.resisterUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

}
