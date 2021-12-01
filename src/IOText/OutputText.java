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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class OutputText {

    public OutputText() {
    }

    //Recibe un file y crea el objeto patient. return Patient
    public Patient outputPatientDataText(String fileName) {
        Patient patient = null;
        File file = new File("PatientsDB/" + fileName + "/" + fileName + ".txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);

        try {
            String dni = br.readLine();
            String name = br.readLine();
            String surname = br.readLine();
            DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date dob = dateFormat.parse(br.readLine());
            String address = br.readLine();
            String email = br.readLine();
            Integer age = Integer.parseInt(br.readLine());
            String sexe = br.readLine();
            String doctor = br.readLine();

            patient = new Patient(dni, name, surname, dob, address, email, age, sexe);
            System.out.println(patient.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return patient;
    }

    //Recibe un file y crea un objeto bitalino. return Bitalino!!!!!!!
    public ArrayList showBitalinoSignal(String nameFile) {
        File file = new File("PatientsDB/08765425t/signal.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        br = new BufferedReader(fr);
        ArrayList<Integer> arrayPulses = new ArrayList();
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                arrayPulses.add(Integer.parseInt(line));

            }
        } catch (IOException ex) {
            Logger.getLogger(OutputText.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPulses;
    }
}
