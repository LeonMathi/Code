import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String messageFromClient = in.readLine();
            System.out.println("Received from client: " + messageFromClient);

            out.println("Hello from Server!");

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
