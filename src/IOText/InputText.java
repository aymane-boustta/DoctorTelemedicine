/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOText;

//import Bitalino.Frame;
import Pojos.Patient;
import java.io.*;

/**
 *
 * @author diego
 */
public class InputText {

    public InputText() {
    }

    //Crear metodo para escribir guardar conjtraseña referenciada a Dna en el servidor
    //Metodo para escribir Patient en .txt
    public void inputPatientDataText(Patient patient) {

        FileWriter file = null;
        PrintWriter pw = null;

        //check if the directory of the patient exists
        File carpeta = new File("PatientsDB/" + patient.getName());
        if (carpeta.exists()) {
            System.out.println("Patient is already in the DB");
        } else {
            try {
                File newCarpeta = new File("PatientsDB/" + patient.getName());
                newCarpeta.mkdir();
                file = new FileWriter("PatientsDB/" + patient.getName() + "/" + patient.getName() + ".txt");
                pw = new PrintWriter(file);

                pw.println(patient.getName());//name
                pw.println(patient.getSurname());//surname
                pw.println(patient.getDob());//dob
                pw.println(patient.getAddress());//address
                pw.println(patient.getEmail());//email
                pw.println(patient.getAge());//age
                pw.println(patient.getSexe());//sex

                // lo envio en un socket que recibo como parametro.
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void inputPassword(String encodedPassword, String Dni) {
        FileWriter file = null;
        PrintWriter pw = null;

        //Chech if the patient is already registered
        File passwordFile = new File("PasswordDB/" + Dni);
        if (passwordFile.exists()) {
            System.out.println("Not possible to store the password, this patient already exists");
        } else {
            try {
                //tools to write in a txt file
                File newFile = new File("PasswordDB/" + Dni);
                newFile.mkdir();
                file = new FileWriter("PasswordDB/" + Dni + "/" + Dni + ".txt");
                pw = new PrintWriter(file);
                pw.println(encodedPassword);

                //send through socket
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    file.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

   
}
