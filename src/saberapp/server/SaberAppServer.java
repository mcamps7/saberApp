package saberapp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import saberapp.connection.SaberAppConnection;

/**
 *
 * @author Pau
 */
public class SaberAppServer extends SaberAppConnection {

    public static final int PROFESSOR = 1;
    public static final int ALUMNE = 2;

    //Constructor pel que instanciem una connexi� de tipus Servidor
    public SaberAppServer(String tipo) throws IOException {
        super("server");
    }

    /**
     * M�tode que inicia el server
     * Divideix el fluxe segons les peticions vinguin e la app de professors
     * o d'alumnes
     */
    public void startServer() {
        try {
            System.out.println("Esperant..."); //Esperant connexi�

            cs = ss.accept(); //Accept comen�a el socket i espera una connexi� des d'un client

            //S'obt� el flux de sortida del client per enviar-li missatges
            sortidaServer = new DataOutputStream(cs.getOutputStream());
            sortidaServer.writeUTF("Petici� rebuda i acceptada");//Informem de l'�xit

            //S'obt� el flux entrant des del client
            entradaServer = new DataInputStream(cs.getInputStream());

            //Rebem quin tipus de client reber: professor(1) o alumne(2)
            int tipus = entradaServer.readInt();

            switch (tipus) {
                case PROFESSOR:
                    System.out.println("Client PROFESSOR en l�nia");
                    SaberAppServer_Professor sap = new SaberAppServer_Professor();
                    sap.startServerProfessor(entradaServer, sortidaServer);
                    break;

                case ALUMNE:
                    System.out.println("Client ALUMNE en linia");
                    SaberAppServer_Alumne saa = new SaberAppServer_Alumne();
                    saa.startServerAlumne(entradaServer, sortidaServer);
                    break;

                default:
                    System.out.println("Altre tipus de client");
                    break;
            }

            //System.out.println("Fin de la conexi�n");
            //ss.close();//Finalitza la connexi� amb el client
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
