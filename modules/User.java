package modules;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class User {

    // دي بيانات اليوزر الأساسية اللي كل الكلاسات التانية هتورثها
    protected int id;           // رقم تعريفي لكل يوزر
    protected String name;      // اسم اليوزر
    protected String phone;     // رقم الموبايل
    protected String username;  // اسم المستخدم اللي بيدخل بيه
    protected String password;  // الباسوورد اللي بيدخل بيه
    protected String role;      // نوع اليوزر (admin / member / coach)

    // دا الصندوق اللي بيتخزن فيه كل الإشعارات اللي بتوصل للمستخدم
    protected ArrayList<Notification> inbox = new ArrayList<Notification>();

    // دا الكونستركتور اللي بيستقبل بيانات اليوزر أول ما بنعمله Create
    public User(int id, String name, String phone, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public static ArrayList<User> loadUsers() throws FileNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\LENOVO\\Downloads\\mavenproject2\\src\\main\\java\\data\\users.txt");
            if (!file.exists()) {
                return users;
            }
            Scanner rf = new Scanner(file);
            while (rf.hasNext()) {
                String line = rf.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phone = parts[2];
                    String username = parts[3];
                    String password = parts[4];
                    String role = parts[5].toLowerCase();

                    switch (role) {
                        case "coach":
                            users.add(new Coach(id, name, phone, username, password, role));
                            break;

                        case "admin":
                            users.add(new Admin(id, name, phone, username, password, role));
                            break;

                        case "member":
                            users.add(new Member(id, name, phone, username, password, role));
                            break;

                        default:
                            users.add(new User(id, name, phone, username, password, role));
                            break;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return users;

    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void receiveNotification(Notification n) {
        inbox.add(n);
    }

    public void showInbox() {

        if (inbox.isEmpty()) {
            System.out.println("No notifications.");
            return;
        }

        System.out.println("=== Inbox ===");

        for (Notification note : inbox) {
            System.out.println("- [" + note.getDate() + "] From: "
                    + note.getSender()
                    + " | Message: "
                    + note.getMessage());
        }
    }

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Role: " + role);
    }

    public static User registerUser() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Sign In ===");

        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Role (admin / coach / member): ");
        String role = sc.nextLine().toLowerCase();

        User newUser;
        switch (role) {
            case "coach":
                newUser = new Coach(id, name, phone, username, password, role);
                break;

            case "admin":
                newUser = new Admin(id, name, phone, username, password, role);
                break;
            case "member":
                newUser = new Member(id, name, phone, username, password, role);
                break;
            default:
                newUser = new User(id, name, phone, username, password, role);
                break;
        }
        newUser.saveUser();
        System.out.println("User signed in successfully!");
        return newUser;

    }

    private void saveUser() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\LENOVO\\Downloads\\mavenproject2\\src\\main\\java\\data\\users.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.id + "," + this.name + "," + this.phone + "," + this.username + "," + this.password + "," + this.role);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

}
