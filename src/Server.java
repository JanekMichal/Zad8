import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Thread {
    private static final int PORT = 9091;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("[SERVER] Waiting for client connection... ");
        while(true) {

            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to client. ");
            ClientHandler clientThread  = new ClientHandler(client);
            clients.add(clientThread);

            pool.execute(clientThread);
        }

        //PrintWriter out = new PrintWriter(client.getOutputStream(), true);
         //out.println((new Date()).toString());


         //System.out.println("[SERVER] Sent date. Closing.");
         //client.close();
         //listener.close();



        /*ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client connected");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client: " + str);

        PrintWriter printWriter = new PrintWriter(s.getOutputStream());
        printWriter.println("hi");
        printWriter.flush();*/
    }
}
