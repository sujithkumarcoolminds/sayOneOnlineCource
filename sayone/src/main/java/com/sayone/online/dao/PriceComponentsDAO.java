package com.sayone.online.dao;


import com.sayone.online.entity.PriceComponents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceComponentsDAO extends CrudRepository<PriceComponents,Integer> {
}
