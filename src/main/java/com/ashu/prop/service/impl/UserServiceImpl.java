package com.ashu.prop.service.impl;

import com.ashu.prop.converter.UserConverter;
import com.ashu.prop.dto.UserDTO;
import com.ashu.prop.entity.UserEntity;
import com.ashu.prop.repository.IUserRepository;
import com.ashu.prop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO resisterUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertUserDTOtoUserEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertUserEntitytoUserDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
