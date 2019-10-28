/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.dtos;

/**
 *
 * @author Pau
 */
public class Professor extends Usuari {
    
    private String materia;

    public Professor(int id, String nick, String password, String nom, String cognoms, String email, String imatge, Institut institut, String materia) {
        super(id, nick, password, nom, cognoms, email, imatge, institut);
        this.materia = materia;
    }

    public Professor() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

}
