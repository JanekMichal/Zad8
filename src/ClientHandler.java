import java.io.*;
import java.net.Socket;



public class ClientHandler implements Runnable{ // jest jedną instancją klienta dla serwera
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.out = new PrintWriter(client.getOutputStream(), true);
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("weszło");
                String data = in.readLine();
                System.out.println("super");
            }

        } catch (IOException IOE) {
            System.out.println("Połaczenie zakończone.");
        }

    }
}
