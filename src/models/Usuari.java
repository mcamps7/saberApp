/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.ImageIcon;

/**
 *
 * @author Montse
 */
public class Usuari {
    //Atributs
    private int id;
    private String nick;
    private String password;
    private String nom;
    private String cognoms;
    private String email;
    private ImageIcon imatge;
    private String institut;

    //Constructor
    public Usuari(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
    
    

    //Getters i setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageIcon getImatge() {
        return imatge;
    }

    public void setImatge(ImageIcon imatge) {
        this.imatge = imatge;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }
    
}
