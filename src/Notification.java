import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Notification implements Serializable {
    public Date date;
    public String msg;

    public Notification(Date date, String msg) throws  DateException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        if (date.compareTo(currentDate) > 0) {
            this.date = date;
            this.msg = msg;
        } else {
            throw new DateException();
        }
    }

    public String getMsg() {
        return this.msg;
    }
    public int compareDate(Date date) throws DateException { //tego prawodopodobnie nie potrzewbuję
        long helper = this.date.getTime() - date.getTime();
        if (Math.abs(helper) <= 1000)
            return 1;
        else if (helper < 0)
            throw new DateException();
        else
            return 0;
    }
    public void testDate() {

    }
}
