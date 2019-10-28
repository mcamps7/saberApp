/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.main;

import java.io.IOException;
import saberapp.client.alumne.SaberAppClientAlumne;

/**
 *
 * @author Pau
 */
public class MainClientAlumne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SaberAppClientAlumne cli = new SaberAppClientAlumne();

        System.out.println("Iniciant Client Alumne\n");

        cli.startClient();
    }

}
