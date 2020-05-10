import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    public Date date;
    public String msg;

    public Notification(Date date, String msg) throws  DateException {
        Date currentDate = new Date();
        if (date.compareTo(currentDate) > 0) {
            this.date = date;
            this.msg = msg;
        } else {
            throw new DateException();
        }
    }
    public Notification(Date date) throws  DateException {
        Date currentDate = new Date();
        if (date.compareTo(currentDate) > 0) {
            this.date = date;
        } else {
            throw new DateException();
        }
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
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

}
