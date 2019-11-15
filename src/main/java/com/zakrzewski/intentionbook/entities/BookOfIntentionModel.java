package com.zakrzewski.intentionbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;

@Entity
@Table(name = "book_of_intention")
public class BookOfIntentionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_mass", nullable = false)
    private String dateOfMass;

    @Column(name = "time_of_mass", nullable = false)
    private String timeOfMass;

    @Column(name = "description_of_intention", nullable = false)
    private String descriptionOfIntention;

    @Column(name = "which_priest", nullable = false)
    private String whichPriest;

    @Column(name = "others_attention", nullable = false)
    private String othersAttention;

    @Column(name = "payment", nullable = false)
    private String payment;

    public BookOfIntentionModel() {
    }

    public BookOfIntentionModel(String dateOfMass, String timeOfMass, String descriptionOfIntention, String whichPriest, String othersAttention, String payment) {
        this.dateOfMass = dateOfMass;
        this.timeOfMass = timeOfMass;
        this.descriptionOfIntention = descriptionOfIntention;
        this.whichPriest = whichPriest;
        this.othersAttention = othersAttention;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfMass() {
        return dateOfMass;
    }

    public void setDateOfMass(String dateOfMass) {
        this.dateOfMass = dateOfMass;
    }

    public String getTimeOfMass() {
        return timeOfMass;
    }

    public void setTimeOfMass(String timeOfMass) {
        this.timeOfMass = timeOfMass;
    }

    public String getDescriptionOfIntention() {
        return descriptionOfIntention;
    }

    public void setDescriptionOfIntention(String descriptionOfIntention) {
        this.descriptionOfIntention = descriptionOfIntention;
    }

    public String getWhichPriest() {
        return whichPriest;
    }

    public void setWhichPriest(String whichPriest) {
        this.whichPriest = whichPriest;
    }

    public String getOthersAttention() {
        return othersAttention;
    }

    public void setOthersAttention(String othersAttention) {
        this.othersAttention = othersAttention;
    }

    @JsonIgnore
    public String getPayment() {
        return payment;
    }
    @JsonSetter
    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "BookOfIntentionModel{" +
                "id=" + id +
                ", dateOfMass='" + dateOfMass + '\'' +
                ", timeOfMass='" + timeOfMass + '\'' +
                ", descriptionOfIntention='" + descriptionOfIntention + '\'' +
                ", whichPriest='" + whichPriest + '\'' +
                ", othersAttention='" + othersAttention + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
