package com.sayone.online.dao;


import com.sayone.online.entity.Country;
import com.sayone.online.entity.Course;
import com.sayone.online.entity.CourseComponent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourceComponentDAO extends CrudRepository<CourseComponent,Integer> {

    @Query("FROM CourseComponent ccv where ccv.course=:course and ccv.componentValue.countryId=:country")
    List<CourseComponent> findByCourseAndCountry(Course course, Country country);
}
