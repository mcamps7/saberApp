/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.main;

import java.io.IOException;
import saberapp.client.professor.SaberAppClientProfessor;

/**
 *
 * @author Pau
 */
public class MainClientProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SaberAppClientProfessor cli = new SaberAppClientProfessor();

        System.out.println("Iniciant Client Professor\n");

        cli.startClient();
    }

}
