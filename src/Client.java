import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class Client {
    private static final int SERVER_PORT = 9090;
    private static final String SERVER_IP = "127.0.0.1";
    private static DateFormat date;

    private void setDate() {
        this.date = new SimpleDateFormat("hh:mm:ss");
    }

    public static void main(String[] args) throws IOException, DateException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String serverResponse = input.readLine();



        DateFormat dateFormat = new SimpleDateFormat("dd HH:mm:ss");
        Date time;


        System.out.println("Notification: ");
        String note = scanner.nextLine();
        System.out.println("Date in format dd hh:mm:ss");
        String SendDate = scanner.nextLine();
        time = dateFormat.parse(SendDate);
        Notification toSend = new Notification(time, note);
        toSend.compareDate(new Date());



        //toSend.compareDate(date);
        System.out.println(note.getMsg());
        //JOptionPane.showMessageDialog(null, serverResponse);
        socket.close();

        System.exit(1);

        /*Socket s = new Socket("localhost", 4999);

        PrintWriter printWriter = new PrintWriter(s.getOutputStream());
        printWriter.println("hello");
        printWriter.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Server: " + str);*/
    }
}
