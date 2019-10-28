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
import java.sql.SQLException;

/**
 *
 * @author Pau
 */
public class AlumneDAO {

    Driver driver;
    String url = "jdbc:postgresql://saperappserver.postgres.database.azure.com/saberapp";
    String user = "prodelpe@saperappserver";
    String password = "Setciencies.2019!";
    Connection con;

    //Constructor
    public AlumneDAO() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);
    }

    /**
     * Insereix un professor a la base de dades TODO: Ho hauria de fer amb un
     * objecte professor???
     *
     * @param nick
     * @param password
     * @param nom
     * @param cognoms
     * @param mail
     * @param image
     * @param id_institut
     * @param curs
     */
    @SuppressWarnings("empty-statement")
    public void insert(String nick, String password, String nom, String cognoms, String mail, String image, int id_institut, String curs) {

        //Creem un objecte PreparedStatement
        PreparedStatement stm = null;

        try {
            //Creem la query d'inserir
            stm = con.prepareStatement("INSERT INTO alumnes (nick, password, nom, cognoms, mail, image, id_institut, curs) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stm.setString(1, nick);
            stm.setString(2, password);
            stm.setString(3, nom);
            stm.setString(4, cognoms);
            stm.setString(5, mail);
            stm.setString(6, image);
            //stm.setInt(8, as.getInstitut().getId());//TODO-> Sustituir id institut per Objecte Institut
            stm.setInt(7, id_institut);
            stm.setString(8, curs);

            //Llancem la query d'inserció
            stm.executeUpdate();

            System.out.println("Dades introduïdes");

        } catch (SQLException ex) {
            System.out.println("Error en la inserció de les dades");
            ex.printStackTrace(System.out);

            /**
             * Per acabar, evitaem el llançament de qualsevol excepció durant el
             * procés de tancament. Una possible forma és capsular cada
             * tancament entre sentències try-catch.
             */
        } finally {
            try {
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el tancament de la base dades");
                ex.printStackTrace(System.out);
            }
        }
    }
}
