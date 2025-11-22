package modules;

import java.time.LocalDateTime;

public class Notification {

    private String message;
    private LocalDateTime date;
    private String sender;

    public Notification(String message, String sender) {
        this.message = message;
        this.sender = sender;
        this.date = LocalDateTime.now();
    }

    public String getMessage() { return message; }
    public String getSender() { return sender; }
    public LocalDateTime getDate() { return date; }
}
