import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private static final int SERVER_PORT = 9091;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        //BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream OIS = new ObjectInputStream(socket.getInputStream());
        while(true) {
            System.out.println("Set your notification time. The format is yyyy-MM-dd HH:mm:ss");
            String settingDate = scanner.nextLine();
            //String settingDate = "2020-5-10 20:02:00";
            try {
                Date date = dateFormat.parse(settingDate);
                Notification newNote = new Notification(date);
                System.out.println("Your Notification is set to " + settingDate);
                try {
                    System.out.println("Now, type your notification text:");
                    String note = scanner.nextLine();
                    newNote.setMsg(note);
                    OOS.writeObject(newNote);
                    OOS.flush();
                    Notification toShow = (Notification) OIS.readObject();
                    System.out.println(toShow.getMsg());
                } catch (ClassNotFoundException CNFE) {
                    System.out.println("Class not found");
                }
            } catch (ParseException PE) {
                System.out.println("Wrong date format. The format is yyyy-MM-dd HH:mm:ss");
            } catch (DateException ignored) {}
        }
    }
}
