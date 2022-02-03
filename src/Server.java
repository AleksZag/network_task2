import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("server started");
        int port = 9002;

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {

            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
            final String firstMessage = in.readLine();
            System.out.println("Incoming message: " + firstMessage + ", port number " + clientSocket.getPort());

            out.println("Hello, client! Write your name");
            final String clientName = in.readLine();
            System.out.println("Client name: " + clientName);

            out.println("Are you child? (yes/no)");
            final String childVerification = in.readLine();

            if (childVerification.equals("yes")) {
                System.out.println(clientName + " is a kid");
                out.println("Welcome to the kids area " + clientName + " Let's play!");
            } else {
                out.println("Welcome to the adult zone, " + clientName + " Have a good rest, or a good working day!");
            }

            clientSocket.close();

        }

    }
}
