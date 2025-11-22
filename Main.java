import modules.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserManager um = new UserManager();

        // Load users from file
        um.getAllUsers().addAll(FileManager.loadUsers());

        // First time run: create default admin
        if (um.getAllUsers().isEmpty()) {
            System.out.println("No users found. Creating default admin...");
            um.addUser(new Admin(1, "Admin", "0100", "admin", "1234"));
            FileManager.saveUsers(um.getAllUsers());
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Health Club Login ===");
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        User logged = um.login(u, p);

        if (logged == null) {
            System.out.println("Login failed. Wrong username or password.");
            return;
        }

        System.out.println("Login successful!");
        System.out.println("Welcome " + logged.name + " (" + logged.role + ")");

        // Routing based on role
        switch (logged.role) {
            case "admin":
                System.out.println("Admin menu loading...");
                logged.showInfo();
                break;

            case "member":
                System.out.println("Member menu loading...");
                logged.showInfo();
                break;

            case "coach":
                System.out.println("Coach menu loading...");
                logged.showInfo();
                break;
        }

        // Save before exit
        FileManager.saveUsers(um.getAllUsers());
    }
}
