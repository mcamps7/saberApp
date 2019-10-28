package saberapp.client.professor.gestors;

import java.io.DataInputStream;
import saberapp.connection.SaberAppConnection;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import saberapp.dtos.Institut;

/**
 * Classe per posar els métodes connectar un client professor amb el server
 *
 * @author Montse
 */
public class GestorClientProfessor extends SaberAppConnection {

    //Necesari per des serialitzar: 
    //https://stackoverflow.com/questions/29946475/writing-aborted-java-io-notserializableexception
    private static final long serialVersionUID = -1892561327013038124L;

    //Constructor. Instanciem una connexió de tipus client
    public GestorClientProfessor() throws IOException {
        super("client");
    }

    /**
     * Métode per iniciar el client
     */
    public void startClient() {
        try {
            entradaClient = new DataInputStream(cs.getInputStream());
            String line = entradaClient.readUTF();
            System.out.println("Server Message: " + line);

            //Flujo de datos hacia el servidor
            sortidaClient = new DataOutputStream(cs.getOutputStream());

            //Enviem un 1 perque el servidor sàpiga que es connecta un professor
            sortidaClient.writeInt(1);

            
            //cs.close();//Fin de la conexión
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void login() throws IOException {
        Scanner teclat = new Scanner(System.in);

        System.out.println("User");
        String user = teclat.nextLine();
        sortidaClient.writeUTF(user);

        System.out.println("Password");
        String password = teclat.nextLine();
        sortidaClient.writeUTF(password);

        entradaClient = new DataInputStream(cs.getInputStream());
        int line = entradaClient.readInt();
        System.out.println("Server Message: " + line);
        //1 existeix / 2 no existeix / 3 error
    }

    
    private void allInstituts() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("instituts.obj"));
        String str = (String) entrada.readObject();
        List<Institut> llista = (List<Institut>) entrada.readObject();

        System.out.println(str);

        for (Institut in : llista) {
            System.out.println(in.getNom());
        }
    }

    private void logout() {
        try {
            cs.close();
        } catch (IOException ex) {
            System.out.println("Error al close()");
            ex.printStackTrace();
        }
    }

}