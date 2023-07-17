package com.ashu.prop.repository;

import com.ashu.prop.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPropertyRepository extends CrudRepository<PropertyEntity, Long> {
}