
package com.zakrzewski.intentionbook.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "season",
    "season_week",
    "celebrations",
    "weekday"
})
public class CalendarApi {

    @JsonProperty("date")
    private String date;
    @JsonProperty("season")
    private String season;
    @JsonProperty("season_week")
    private Integer seasonWeek;
    @JsonProperty("celebrations")
    private List<Celebration> celebrations = null;
    @JsonProperty("weekday")
    private String weekday;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("season")
    public String getSeason() {
        return season;
    }

    @JsonProperty("season")
    public void setSeason(String season) {
        this.season = season;
    }

    @JsonProperty("season_week")
    public Integer getSeasonWeek() {
        return seasonWeek;
    }

    @JsonProperty("season_week")
    public void setSeasonWeek(Integer seasonWeek) {
        this.seasonWeek = seasonWeek;
    }

    @JsonProperty("celebrations")
    public List<Celebration> getCelebrations() {
        return celebrations;
    }

    @JsonProperty("celebrations")
    public void setCelebrations(List<Celebration> celebrations) {
        this.celebrations = celebrations;
    }

    @JsonProperty("weekday")
    public String getWeekday() {
        return weekday;
    }

    @JsonProperty("weekday")
    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
