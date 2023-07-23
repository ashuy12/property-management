package com.ashu.prop.converter;

import com.ashu.prop.dto.UserDTO;
import com.ashu.prop.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertUserDTOtoUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPhoneNo(userDTO.getPhoneNo());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

    public UserDTO convertUserEntitytoUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhoneNo(userEntity.getPhoneNo());
        return userDTO;
    }

}
