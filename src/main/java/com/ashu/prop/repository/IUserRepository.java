package com.ashu.prop.repository;

import com.ashu.prop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

    //@Query("SELECT u FROM User_Table WHERE u.ownerEmail = ?1 AND u.password = ?2")
    Optional<UserEntity> findByOwnerEmailAndPassword(String email, String password);

    Optional<UserEntity> findByOwnerEmail(String email);
}