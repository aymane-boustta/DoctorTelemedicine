/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbookair
 */
public class ServerThreadsPatient implements Runnable {

    /**
     * @param args the command line arguments
     */
    Socket socket;

    public ServerThreadsPatient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }

        try {
            out = new FileOutputStream("PatientsDB/nuevaPrueba" + Math.random() * 6 + ".txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[16 * 1024];

        int count;
        try {
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
