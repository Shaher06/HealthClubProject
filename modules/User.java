package modules;

import java.util.ArrayList;

public class User {
    protected int id;
    protected String name;
    protected String phone;
    protected String username;
    protected String password;
    protected String role;

    protected ArrayList<String> inbox = new ArrayList<>();

    public User(int id, String name, String phone, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void sendMessage(String msg) {
        inbox.add(msg);
    }

    public void showInbox() {
        if (inbox.isEmpty()) {
            System.out.println("No messages.");
            return;
        }
        System.out.println("=== Inbox ===");
        for (String msg : inbox) System.out.println("- " + msg);
    }

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Role: " + role);
    }
}
protected ArrayList<Notification> inbox = new ArrayList<>();

public void sendNotification(Notification n) {
    inbox.add(n);
}

