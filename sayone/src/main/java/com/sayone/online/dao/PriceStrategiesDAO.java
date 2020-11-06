package com.sayone.online.dao;


import com.sayone.online.entity.PriceStrategies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceStrategiesDAO extends CrudRepository<PriceStrategies,Integer> {
}
