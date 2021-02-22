package hwLes06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int PORT = 8611;

    public static void main(String[] args) {
        startingServer();
    }

    private static void startingServer() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is start");

            try(
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    Scanner scanner = new Scanner(System.in);
                    PrintWriter out = new PrintWriter(socket.getOutputStream())
            ) {
                System.out.println("Client connect");
                Thread thread = new Thread(() -> {
                    String inputMessage = "";
                    try {
                        do {
                            inputMessage = in.readLine();
                            System.out.println("Client: " + inputMessage);
                        } while (!inputMessage.equalsIgnoreCase("exit"));

                } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                thread.start();

                String outputMessage = "";
                while(true) {
                    outputMessage = scanner.nextLine();
                    out.println(outputMessage);
                    out.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
