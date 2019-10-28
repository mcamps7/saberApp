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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import saberapp.dtos.Institut;
import saberapp.dtos.Professor;

/**
 *
 * @author Pau
 */
public class ProfessorDAO {

    Driver driver;
    String url = "jdbc:postgresql://saperappserver.postgres.database.azure.com/saberapp";
    String user = "prodelpe@saperappserver";
    String password = "Setciencies.2019!";
    Connection con;

    //Constructor
    public ProfessorDAO() throws ClassNotFoundException, SQLException {
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
     * @param materia
     */
    @SuppressWarnings("empty-statement")
    public void insert(String nick, String password, String nom, String cognoms, String mail, String image, int id_institut, String materia) {

        //Creem un objecte PreparedStatement
        PreparedStatement stm = null;

        try {
            //Creem la query d'inserir
            stm = con.prepareStatement("INSERT INTO professors (nick, password, nom, cognoms, mail, image, id_institut, materia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stm.setString(1, nick);
            stm.setString(2, password);
            stm.setString(3, nom);
            stm.setString(4, cognoms);
            stm.setString(5, mail);
            stm.setString(6, image);
            //stm.setInt(8, as.getInstitut().getId());//TODO-> Sustituir id institut per Objecte Institut
            stm.setInt(7, id_institut);
            stm.setString(8, materia);

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

    /**
     * Retorna una llista amb tots els instituts registrats a la BD Aquesta
     * llista servirà per pintar els selects amb els instituts perque els
     * usuaris piguin seleccionar el seu d'una llista tancada
     *
     * @return
     */
    public List<Institut> allInstituts() {

        List<Institut> instituts = new ArrayList<Institut>();

        PreparedStatement stm = null;
        ResultSet rs;

        try {

            stm = con.prepareStatement("SELECT id, nom, ciutat FROM instituts");
            rs = stm.executeQuery();

            //Recorrem les files de la query i actuem per cada una de elles
            while (rs.next()) {
                //Transformem cada fila en un objecte Professor que afegim a l'ArryList
                instituts.add(recuperaInstitut(rs));
            }

        } catch (SQLException ex) {
            System.out.println("Error en la recuperació dels instituts");
            ex.printStackTrace(System.out);

            //Assegurem el tancament
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

        return instituts;
    }

    /**
     *
     * @param rs
     * @return
     * @throws GestorException
     */
    private Institut recuperaInstitut(ResultSet rs) {
        try {
            Institut in = new Institut();

            in.setId(rs.getInt("id"));
            in.setNom(rs.getString("nom"));
            in.setCiutat(rs.getString("ciutat"));

            return in;

        } catch (SQLException ex) {
            System.out.println("Error al recuperar un dels instituts (recuperaInstitut())");
            ex.printStackTrace();
            return null;
        }

    }

}
