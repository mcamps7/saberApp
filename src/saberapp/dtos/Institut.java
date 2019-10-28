/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.dtos;

import java.io.Serializable;

/**
 *
 * @author Pau
 */
public class Institut implements Serializable {

    //Necesari per des serialitzar: 
    //https://stackoverflow.com/questions/29946475/writing-aborted-java-io-notserializableexception
    private static final long serialVersionUID = -1892561327013038124L;

    private int id;
    private String nom;
    private String ciutat;

    public Institut(int id, String nom, String ciutat) {
        this.id = id;
        this.nom = nom;
        this.ciutat = ciutat;
    }

    public Institut() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

}