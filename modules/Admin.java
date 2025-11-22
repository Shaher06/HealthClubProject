package modules;

public class Admin extends User {

    public Admin(int id, String name, String phone, String username, String password) {
        super(id, name, phone, username, password, "admin");
    }

    // Admin-specific operations will be handled by team
    public void adminMenu() {
        System.out.println("Admin menu will be here...");
    }
}
