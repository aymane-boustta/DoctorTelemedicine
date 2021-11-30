/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author macbookair
 */
public class Patient implements Serializable {

    private static final long serialVersionUID = -1156840724257282729L;
    private Integer id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String email;
    private String medicalHistory;
    private int age;
    private String sexe;
    //private Doctor doctor;
    private String doctor;

    public Patient(Integer id, String name, String surname, Date dob, String address, String email, String medicalHistory, int age, String sexe, String doctor) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.medicalHistory = medicalHistory;
        this.age = age;
        this.sexe = sexe;
        this.doctor = doctor;
    }

    //costructor sin Id,medicalHistory
    public Patient(String name, String surname, Date dob, String address, String email, int age, String sexe, String doctor) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.age = age;
        this.sexe = sexe;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", address=" + address + ", email=" + email + ", medicalHistory=" + medicalHistory + ", age=" + age + ", sexe=" + sexe + ", doctor=" + doctor + '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

}
