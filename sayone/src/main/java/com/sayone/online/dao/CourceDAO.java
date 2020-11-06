package com.sayone.online.dao;

import com.sayone.online.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourceDAO extends CrudRepository<Course,Integer> {


    /*@Query("FROM CourseComponent ccv where ccv.course=:course and ccv.componentValue.countryId=:country")
    List<CourseComponent> findByCourseAndCountry(Course course, Country country);*/

   /* @Query("FROM Course c where c.id=:courseId")
    Course findByCourseId(Integer courseId);*/
}
