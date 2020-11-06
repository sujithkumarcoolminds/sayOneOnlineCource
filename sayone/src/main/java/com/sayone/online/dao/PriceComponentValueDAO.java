package com.sayone.online.dao;


import com.sayone.online.entity.PriceComponentValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceComponentValueDAO extends CrudRepository<PriceComponentValue,Integer> {

}
