package modules;

public class Coach extends User {

    public Coach(int id, String name, String phone, String username, String password) {
        super(id, name, phone, username, password, "coach");
    }

    public void coachMenu() {
        System.out.println("Coach menu will be here...");
    }
}
