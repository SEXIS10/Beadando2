package com.projekt.beadando.Classes;

import com.projekt.beadando.Enums.Nationality;
import com.projekt.beadando.Enums.Sex;

import java.sql.Date;

public class User
{
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private String birthplace;
    private Sex sex;
    private boolean active;
    private Nationality nationality;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthDate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthDate = birthdate;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Nationality getNationality() {
        return nationality;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getBirthplace() {
        return birthplace;
    }
    public void setBirthplace(String place) {
        this.birthplace = place;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = Sex.valueOf(sex);
    }

    public User(String name, String username, String password, String email, Date birthDate, String birthplace, String sex, boolean active, String nationality) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.sex = Sex.valueOf(sex);
        this.active = active;
        this.nationality = Nationality.valueOf(nationality);
    }

    public User(int id, String name, String username, String password, String email, Date birthDate, String birthplace, Sex sex, boolean active, Nationality nationality) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.sex = sex;
        this.active = active;
        this.nationality = nationality;
    }
}
