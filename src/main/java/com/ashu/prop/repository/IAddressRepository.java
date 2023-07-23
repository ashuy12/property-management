package com.ashu.prop.repository;

import com.ashu.prop.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepository extends CrudRepository<AddressEntity, Long> {

}
