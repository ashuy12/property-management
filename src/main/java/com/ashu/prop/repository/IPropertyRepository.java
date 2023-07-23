package com.ashu.prop.repository;

import com.ashu.prop.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPropertyRepository extends CrudRepository<PropertyEntity, Long> {

    //@Query("SELECT p FROM PropertyEntity p WHERE p.userEntity.id = :userId")
    List<PropertyEntity> findAllByUserEntityId(@Param("userId") Long userId);
}