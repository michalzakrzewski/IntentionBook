package com.zakrzewski.intentionbook.abstractClass;

import com.zakrzewski.intentionbook.enums.AccessEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "church_worker")
public abstract class ChurchWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_access")
    private AccessEnum accessEnum;

    public ChurchWorker(String firstName, String lastName, AccessEnum accessEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessEnum = accessEnum;
    }

    public ChurchWorker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccessEnum getAccessEnum() {
        return accessEnum;
    }

    public void setAccessEnum(AccessEnum accessEnum) {
        this.accessEnum = accessEnum;
    }

    @Override
    public String toString() {
        return "ChurchWorker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessEnum=" + accessEnum +
                '}';
    }
}
