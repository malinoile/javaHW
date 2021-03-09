package hwLes06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        startClient();
    }

    private static void startClient() {
        try(
                Socket socket = new Socket("localhost", Server.PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner sc = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            Thread thread = new Thread(() -> {
                String inputMessage = "";
                try {
                    while(!socket.isClosed()) {
                        inputMessage = in.readLine();
                        System.out.println("Client: " + inputMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Вы были отключены от сервера");
                }
            });
            thread.start();

            String message = "";
            do {
                message = sc.nextLine();
                out.println(message);
                out.flush();
            } while(!message.equalsIgnoreCase("exit"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
