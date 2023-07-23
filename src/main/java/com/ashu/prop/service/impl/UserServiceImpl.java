package com.ashu.prop.service.impl;

import com.ashu.prop.converter.UserConverter;
import com.ashu.prop.dto.UserDTO;
import com.ashu.prop.entity.UserEntity;
import com.ashu.prop.exception.ApplicationException;
import com.ashu.prop.exception.InvalidLoginException;
import com.ashu.prop.repository.IUserRepository;
import com.ashu.prop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO resisterUser(UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUserEntity.isPresent()) {
            throw new ApplicationException("User already exists!");
        } else {
            UserEntity userEntity = userConverter.convertUserDTOtoUserEntity(userDTO);
            userEntity = userRepository.save(userEntity);
            userDTO = userConverter.convertUserEntitytoUserDTO(userEntity);
            return userDTO;
        }
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity =
            userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()) {
            userDTO = userConverter.convertUserEntitytoUserDTO(optionalUserEntity.get());
        } else {
            throw new InvalidLoginException("User email or password is not correct!");
        }
        return userDTO;
    }
}
