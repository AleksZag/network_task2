import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 9002;
        Scanner scanner = new Scanner(System.in);


        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            out.println("Hello, server!");

            while (!clientSocket.isClosed()) {

                String resp = in.readLine();
                System.out.println(resp);
                String outMessage = scanner.nextLine();
                out.println(outMessage);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
