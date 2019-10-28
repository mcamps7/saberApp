/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saberapp.server;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pau
 */
public class UsuariDAO {

    Driver driver;
    String url = "jdbc:postgresql://saperappserver.postgres.database.azure.com/saberapp";
    String user = "prodelpe@saperappserver";
    String password = "Setciencies.2019!";
    Connection con;

    //Constructor
    public UsuariDAO() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);
    }

    /**
     * Comprova si l'usuari i la contrasenya son correctes a la BBDD
     *
     * @param nick Nom de l'usuari
     * @param password Contrasenya de l'usuari
     * @return Retorna true si hi es a la BBDD
     */
    public boolean login(String nick, String password) throws ClassNotFoundException, SQLException {

        try {

            //SQL
            PreparedStatement ps = con.prepareStatement("SELECT nick, password FROM professors WHERE nick = ?");
            ps.setString(1, nick);
            ResultSet rs = ps.executeQuery();

            String dbPswd = null;
            while (rs.next()) {
                dbPswd = rs.getString("password");
                System.out.println("password usuari a la BD: " + dbPswd);
            }

            // Comparem la contrasenya amb el resultat de la consulta
            //Si són iguals retornem true
            if (password.equals(dbPswd)) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error SQL a login()");
            ex.printStackTrace();
        }

        return false;

    }
}
