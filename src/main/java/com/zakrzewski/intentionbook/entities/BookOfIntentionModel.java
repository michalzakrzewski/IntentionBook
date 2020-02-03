package com.zakrzewski.intentionbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.zakrzewski.intentionbook.abstractClass.ChurchWorker;
import org.hibernate.annotations.common.reflection.XMethod;

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
    @Column(name = "which_priest")
    private String whichPriest;

    @Column(name = "others_attention")
    private String othersAttention;
    
    @Size(min = 2, max = 50)
    @Column(name = "payment")
    private String payment;

    @ManyToOne()
    @JoinColumn(name = "church_worker_id", nullable = false)
    private ChurchWorker whoAddIntention;

    @Transient
    private String fullName;

    public BookOfIntentionModel() {
    }


    public BookOfIntentionModel(String dateOfMass, String timeOfMass, String descriptionOfIntention, String whichPriest, String othersAttention, String payment, ChurchWorker whoAddIntention) {
        this.dateOfMass = dateOfMass;
        this.timeOfMass = timeOfMass;
        this.descriptionOfIntention = descriptionOfIntention;
        this.whichPriest = whichPriest;
        this.othersAttention = othersAttention;
        this.payment = payment;
        this.whoAddIntention = whoAddIntention;
        this.fullName = getConcatFullName();
    }

    private String getConcatFullName(){
        return this.whoAddIntention.getFirstName() + " " + this.whoAddIntention.getLastName();
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

    public ChurchWorker getWhoAddIntention() {
        return whoAddIntention;
    }

    public void setWhoAddIntention(ChurchWorker whoAddIntention) {
        this.whoAddIntention = whoAddIntention;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
                ", whoAddIntention=" + whoAddIntention +
                '}';
    }
}
