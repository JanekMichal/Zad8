import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotificationTest implements Serializable {
    private LocalDateTime time;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd HH:mm");


}
