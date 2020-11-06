package com.sayone.online.dao;


import com.sayone.online.entity.Course;
import com.sayone.online.entity.StrategiesOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategiesOptionDAO extends CrudRepository<StrategiesOption,Integer> {
    List<StrategiesOption> findByCourse(Course course);

}
