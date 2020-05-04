import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Notification implements Serializable {
    public Date date;
    public String msg;

    public Notification(Date date, String msg) {
        this.date = date;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
    public int compareDate(Date date) throws DateException {
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
