package com.sayone.online.dao;

import com.sayone.online.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDAO extends CrudRepository<Country,Integer> {

   Country findByCode(String code);
}
