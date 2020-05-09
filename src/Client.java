import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private static final int SERVER_PORT = 9091;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        while(true) {
            System.out.println("Podaj datę:");
            String command = keyboard.readLine();
            if(command.equals("Q"))  break;

            out.println(command);

            String serverResponse = input.readLine();
            System.out.println("Server response: " + serverResponse);
        }
    }
        /*try {
            System.out.println("Set your notification time. The format is yyyy-MM-dd HH:mm:ss");
            String settingDate = "2020-5-8 11:30:10";
            //String settingDate = scanner.nextLine();  //odkomentować po napisaniu programu
            try {
                Date date = dateFormat.parse(settingDate);
                System.out.println("Now, type your notification text:");
                String note = scanner.nextLine();
                Notification newNote = new Notification(date, note);                        //Tworzenie notyfikacji
                OOS.writeObject(newNote);                                                    //przesłanie notyfikacji do servera
                OOS.flush();
            } catch (ParseException PE) {
                System.out.println("Wrong Date format.");
            }
        } catch (DateException DE) {}*/
}
