package modules;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.login(username, password)) {
                return u;
            }
        }
        return null; 
    }
}
