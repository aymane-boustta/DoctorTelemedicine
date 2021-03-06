/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ServerThreads {

    public static void main(String args[]) throws IOException {
        //Create a service that is waiting in port 9000
        ServerSocket serverSocket = new ServerSocket(9000);
        try {
            while (true) {
                //Thie executes when we have a client
                Socket socket = serverSocket.accept();
                new Thread(new ServerThreadsPatientUser(socket)).start();
                new Thread(new ServerThreadsPatient(socket)).start();

            }
        } finally {
            releaseResourcesServer(serverSocket);

        }
    }

    private static void releaseResourcesServer(ServerSocket serverSocket) {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
