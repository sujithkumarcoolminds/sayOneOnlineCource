package com.sayone.online.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class OnlineCourse {

    @JsonProperty("courseId")
    private Integer courseId ;

    @JsonProperty("courseName")
    private String courseName ;

    @JsonProperty("course_description")
    private String courseDescription;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @JsonProperty("price_strategies")
    private List<PriceStrategiesModal> priceStrategies = null;

    @JsonProperty("price_components")
    private List<PriceComponentsModal> priceComponents = null;


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PriceStrategiesModal> getPriceStrategies() {
        return priceStrategies;
    }

    public void setPriceStrategies(List<PriceStrategiesModal> priceStrategies) {
        this.priceStrategies = priceStrategies;
    }

    public List<PriceComponentsModal> getPriceComponents() {
        return priceComponents;
    }

    public void setPriceComponents(List<PriceComponentsModal> priceComponents) {
        this.priceComponents = priceComponents;
    }
}
