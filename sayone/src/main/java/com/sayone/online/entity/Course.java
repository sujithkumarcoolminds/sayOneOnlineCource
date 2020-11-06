package com.sayone.online.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name="course")
public class Course implements Serializable {

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public String toString() {
        return "Course{id=" + courseId +
                ", name=" + name +
                ", description=" + description +
                ", durationInMonths=" + durationInMonths +
                "}";
    }
    public Course(Optional<Course> course) {
        this.courseId = course.get().getCourseId();
        this.name = course.get().getName();
        this.description = course.get().getDescription();
        this.durationInMonths = course.get().getDurationInMonths();
    }

    public Course() {
    }
}
