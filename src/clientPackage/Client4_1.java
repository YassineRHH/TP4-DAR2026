package clientPackage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Client4_1 {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = " Mon message ";
            byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket donneesEmises = new DatagramPacket(
                    buffer, buffer.length, InetAddress.getByName("localhost"), 1234);
            socket.send(donneesEmises);
        }
    }
}
