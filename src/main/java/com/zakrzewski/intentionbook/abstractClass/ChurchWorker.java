package com.zakrzewski.intentionbook.abstractClass;

import com.zakrzewski.intentionbook.enums.AccessEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "church_worker")
public abstract class ChurchWorker implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "login")
    private String workerLogin;

    @NotNull
    @Column(name = "password")
    private String workerPassword;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "user_role")
    private String accessEnum;

    private String fullNameWorkers;

    public ChurchWorker(String workerLogin, String workerPassword, String firstName, String lastName, String accessEnum) {
        this.workerLogin = workerLogin;
        this.workerPassword = workerPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessEnum = accessEnum;
        this.fullNameWorkers = concatName();
    }

    public ChurchWorker() {
    }

    private String concatName(){
        return this.getFirstName() + " " + this.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkerLogin() {
        return workerLogin;
    }

    public void setWorkerLogin(String workerLogin) {
        this.workerLogin = workerLogin;
    }


    public String getWorkerPassword() {
        return workerPassword;
    }

    public void setWorkerPassword(String workerPassword) {
        this.workerPassword = workerPassword;
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

    public String getAccessEnum() {
        return accessEnum;
    }

    public void setAccessEnum(String accessEnum) {
        this.accessEnum = accessEnum;
    }

    public String getFullName() {
        return fullNameWorkers;
    }

    public void setFullName(String fullNameWorkers) {
        this.fullNameWorkers = fullNameWorkers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(accessEnum));
    }

    @Override
    public String getPassword() {
        return workerPassword;
    }

    @Override
    public String getUsername() {
        return workerLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "ChurchWorker{" +
                "id=" + id +
                ", workerLogin='" + workerLogin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accessEnum=" + accessEnum +
                '}';
    }
}
