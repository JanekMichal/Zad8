import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {
    private static final int PORT = 9091;
    private static final ArrayList<ClientHandler> clients = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("[SERVER] Waiting for client connection... ");
        while(true) {
            Socket client = listener.accept();
            ClientHandler clientThread  = new ClientHandler(client);
            clients.add(clientThread);
            System.out.println("[SERVER] Connected to client. ");

            pool.execute(clientThread);
        }

    }
}
