/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOText;

import Pojos.Patient;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author diego
 */
public class OutputText {

    public OutputText() {
    }

    //Recibe un file y crea el objeto patient. return Patient
    public Patient outputPatientDataText(String fileName) {

        File file = new File("PatientsDB/" + fileName + "/" + fileName + ".txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);

        try {
            String name = br.readLine();
            String surname = br.readLine();
            DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date dob = dateFormat.parse(br.readLine());
            String address = br.readLine();
            String email = br.readLine();
            Integer age = Integer.parseInt(br.readLine());
            String sexe = br.readLine();
            String doctor = br.readLine();

            Patient patient = new Patient(name, surname, dob, address, email, age, sexe, doctor);
            System.out.println(patient.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    //Recibe un file y crea un objeto bitalino. return Bitalino!!!!!!!
    public void outputBitalinoDataText() {

    }
}
