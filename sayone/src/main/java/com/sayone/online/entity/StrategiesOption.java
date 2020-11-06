package com.sayone.online.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="strategies_option")
public class StrategiesOption  implements Serializable {

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "price_strategy_id")
    private PriceStrategies priceStrategy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public PriceStrategies getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategies priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public PriceStrategies getPriceStrategyId() {
        return priceStrategy;
    }

    public void setPriceStrategyId(PriceStrategies priceStrategyId) {
        this.priceStrategy = priceStrategyId;
    }

}
