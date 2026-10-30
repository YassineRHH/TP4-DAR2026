package serverPackage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server4_1 {
    private static final int PORT = 1234;
    private static final int TAILLE_BUFFER = 1024;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("[SERVEUR] En ecoute sur le port  " + PORT+"...");
            while (true) {
                byte[] buffer = new byte[TAILLE_BUFFER];
                DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquet);
                int taille = paquet.getLength();
                String donnees = new String(paquet.getData(), 0, taille, StandardCharsets.UTF_8);
                System.out.println("Donnees reçues = " + donnees);
            }
        } catch (IOException e) {
            System.err.println("[SERVEUR] Erreur de reception : " + e.getMessage());
        }
    }
}
