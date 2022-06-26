package lab1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2510);

            while(true){
                Socket socket = server.accept();
                System.out.println("Client was successfully connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
