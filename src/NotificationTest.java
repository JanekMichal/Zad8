import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NotificationTest implements Serializable {
    public static void main(String[] args) throws ParseException, DateException {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String input = scanner.nextLine();              //from user input

        String dateInString = "2020-5-6 11:30:10";      //fixed in programme
        Date currentDate = new Date();
        Date date = dateFormat.parse(dateInString);
        System.out.println("Set date: " + date);
        System.out.println("Current date: " + currentDate);
        if (date.compareTo(currentDate) > 0) {
            System.out.println("dziala");
        } else {
            throw new DateException();
        }
    }
}
