package com.sayone.online.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="course_component_value")
public class CourseComponent  implements Serializable {

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "component_value_id")
    private PriceComponentValue componentValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PriceComponentValue getComponentValue() {
        return componentValue;
    }

    public void setComponentValue(PriceComponentValue componentValue) {
        this.componentValue = componentValue;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }

}
