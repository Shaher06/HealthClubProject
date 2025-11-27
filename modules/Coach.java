package modules;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author LENOVO
 */
import java.util.*;
import java.io.IOException;

public class Coach extends User {

    public Coach(int id, String name, String phone, String username, String password, String role) {
        super(id, name, phone, username, password, role);

    }

    public void addPlan(int memberId, String plan) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\LENOVO\\Downloads\\mavenproject2\\src\\main\\java\\data\\plans.txt", true));
            pw.println(memberId + "," + plan);
            System.out.println("Plan added successfully for member ID: " + memberId);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSheduale(int memberId, String schedule) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\LENOVO\\Downloads\\mavenproject2\\src\\main\\java\\data\\sheduals.txt", true));
            pw.println(memberId + "," + schedule);
        } catch (IOException e) {
            System.out.println("Error saving schedule: " + e.getMessage());
        }

    }
    
    
    public void sendMessageToAllMembers(String message, ArrayList<User> allUsers) {
        for (User u : allUsers) {
            if (u.getRole().equals("member")) {
                Notification n = new Notification(this.name, message); // لازم Notification يكون موجود
              u.receiveNotification(n);
            }
        }
        System.out.println("Message sent to all members!");
    }

}
