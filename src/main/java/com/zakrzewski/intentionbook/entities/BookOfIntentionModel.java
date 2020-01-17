package com.zakrzewski.intentionbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_of_intention")
public class BookOfIntentionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_mass")
    private String dateOfMass;

    @Column(name = "time_of_mass")
    private String timeOfMass;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "description_of_intention")
    private String descriptionOfIntention;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "which_priest")
    private String whichPriest;

    @Column(name = "others_attention")
    private String othersAttention;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "payment")
    private String payment;

    @ManyToOne()
    @JoinColumn(name = "sacristian_id", nullable = false)
    private SacristanModel sacristanModel;

    public BookOfIntentionModel() {
    }

    public BookOfIntentionModel(String dateOfMass, String timeOfMass, String descriptionOfIntention, String whichPriest, String othersAttention, String payment, SacristanModel sacristanModel) {
        this.dateOfMass = dateOfMass;
        this.timeOfMass = timeOfMass;
        this.descriptionOfIntention = descriptionOfIntention;
        this.whichPriest = whichPriest;
        this.othersAttention = othersAttention;
        this.payment = payment;
        this.sacristanModel = sacristanModel;
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

    public SacristanModel getSacristanModel() {
        return sacristanModel;
    }

    public void setSacristanModel(SacristanModel sacristanModel) {
        this.sacristanModel = sacristanModel;
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
