package saberapp.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Dades de connexió
 *
 * @author Pau
 */
public class SaberAppConnection {

    private final int PORT = 9009; //Por per a la connexió (en local, Netbeans servidor Glassfish)
    private final String HOST = "localhost"; //Host per a la connexió
    protected String messageServer; //Missatges entrants per al server
    protected ServerSocket ss; //Socket del server
    public Socket cs; //Socket del client
    public DataOutputStream sortidaServer;
    public DataOutputStream sortidaClient; //Fluxe de dades de sortida
    public DataInputStream entradaServer;
    public DataInputStream entradaClient; //Fluxe de dades d'entrada

    public SaberAppConnection(String tipo) throws IOException //Constructor
    {
        //Si el constructor rep una petició de servidor...
        if (tipo.equalsIgnoreCase("server")) {
            ss = new ServerSocket(PORT);//Es crea el socket per al server al port anomenat
            cs = new Socket(); //Socket per al client
            
        //Si en rep qualsevol altra...    
        } else {
            cs = new Socket(HOST, PORT); //Socket per al cliente al localhost port anomenat
        }
    }
}
