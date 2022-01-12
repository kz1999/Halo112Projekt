package com.example.halo112_generic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "myuser")
//@MappedSuperclass
public class User {

    public User(Long id, String userName, String photo, String passwordHash, String name, String surname, String phoneNumber, String email, String role, boolean confirmed) {
        this.id = id;
        this.userName = userName;
        this.photo = photo;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.confirmed = confirmed;
    }
    
    public User(String userName, String photo, String passwordHash, String name, String surname, String phoneNumber, String email, String role, boolean confirmed) {
        this.userName = userName;
        this.photo = photo;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.confirmed = confirmed;
    }

    public User() {

    }

    @Id
    @GeneratedValue
    private Long id;

    //@Id
    @Column(unique = true)
    @NotNull
    @Size(max=30)
    private String userName;

    @Column(length = 1337)
    private String photo;

    private String passwordHash;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    @NotNull
    private String role;

    private boolean confirmed;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", photo='" + photo + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }
}
