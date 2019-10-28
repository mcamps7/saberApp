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
public class Usuari {

    private int id;
    private String nick;
    private String password;
    private String nom;
    private String cognoms;
    private String email;
    private String imatge;
    private Institut institut;

    public Usuari(int id, String nick, String password, String nom, String cognoms, String email, String imatge, Institut institut) {

        this.id = id;
        this.nick = nick;
        this.password = password;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.imatge = imatge;
        this.institut = institut;
    }

    public Usuari() {
    }

    //-- Getters and setters --
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

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public Institut getInstitut() {
        return institut;
    }

    public void setInstitut(Institut institut) {
        this.institut = institut;
    }

}
