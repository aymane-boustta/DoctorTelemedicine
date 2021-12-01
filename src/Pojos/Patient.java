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

    private String dni;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String email;
    private Integer age;
    private String sexe;
    //private Doctor doctor;

    //costructor sin Id,medicalHistory
    public Patient(String dni, String name, String surname, Date dob, String address, String email, Integer age, String sexe) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.age = age;
        this.sexe = sexe;

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

    public Integer getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDni() {
        return dni;
    }

}
