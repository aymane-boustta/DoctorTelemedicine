/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ServerThreadsPatientUser implements Runnable {

    Socket socket;

    public ServerThreadsPatientUser(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //obtener User y Contraseña
        BufferedReader bufferedReader = null;
        String dni = null;
        String encodedPassword = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line;
        try {
            dni = bufferedReader.readLine();
            encodedPassword = bufferedReader.readLine();

        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Soy el server y he recivido user:" + dni);
        System.out.println("Soy el server y he recivido password:" + encodedPassword);
        //comprobar user y contraseña
        try {
            FileReader file = new FileReader("PasswordDB/" + dni + "/password" + dni + ".txt");
            BufferedReader br = new BufferedReader(file);
            if (br.readLine().equals(encodedPassword)) {
                //enviar paciente ok
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("true");
                //releaseResources(bufferedReader, printWriter, socket);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void releaseResources(BufferedReader b, PrintWriter p, Socket s) {
        try {
            b.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.close();
        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatientUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
