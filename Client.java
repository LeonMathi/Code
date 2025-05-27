import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // or use actual IP if on network
        int port = 5000;

        try (Socket socket = new Socket(serverIP, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello from Client!");

            String messageFromServer = in.readLine();
            System.out.println("Server replied: " + messageFromServer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
