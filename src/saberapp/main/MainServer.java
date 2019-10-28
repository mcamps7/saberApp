/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.main;

import java.io.IOException;
import saberapp.server.SaberAppServer;

/**
 *
 * @author Pau
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SaberAppServer serv = new SaberAppServer("servidor"); //Se crea el servidor

        System.out.println("Iniciant servidor\n");

        while (true) {
            serv.startServer(); //Se inicia el servidor
        }
    }

}
