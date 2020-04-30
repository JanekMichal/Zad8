import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {

        Socket s = new Socket("localhost", 4999);

        PrintWriter printWriter = new PrintWriter(s.getOutputStream());
        printWriter.println("hello");
        printWriter.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("Server: " + str);
    }
}
