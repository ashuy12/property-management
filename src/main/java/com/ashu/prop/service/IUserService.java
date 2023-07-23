package com.ashu.prop.service;

import com.ashu.prop.dto.UserDTO;

public interface IUserService {

    UserDTO resisterUser(UserDTO userDTO);

    UserDTO login(String email, String password);

}
