package com.sayone.online.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceStrategiesModal {

    @JsonProperty("strategyID")
    private Integer strategyID;
    @JsonProperty("name")
    private String name;

    @JsonProperty("duration")
    private Integer duration;

    public Integer getStrategyID() {
        return strategyID;
    }

    public void setStrategyID(Integer strategyID) {
        this.strategyID = strategyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
