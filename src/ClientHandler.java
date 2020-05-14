import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class ClientHandler implements Runnable{
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
            ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream OIS = new ObjectInputStream(client.getInputStream());

            ArrayList<Notification> Notifications = new ArrayList<>();
            while (true) {
                Notification note = (Notification) OIS.readObject();
                Notifications.add(note);
                System.out.println("New  notification just arrived.");

                (new Timer()).schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            Date data = new Date();
                            for (Notification oneNote : Notifications) {
                                System.out.println(data +" " + oneNote.date);
                                try {
                                    if (oneNote.compareDate(data) == 1) {
                                        OOS.writeObject(oneNote);
                                        System.out.println("Sending " + oneNote.getMsg());
                                        Notifications.remove(oneNote);
                                        break;
                                    }
                                }
                                catch (DateException ignored){}
                            }
                        }
                        catch (IOException IOE) {
                            System.out.println("IOException in TimerTask");
                        }
                    }
                }, note.date);
            }
        } catch (IOException | ClassNotFoundException IOE) {
            System.out.println("Client Disconnected. ");
        }
    }
}
