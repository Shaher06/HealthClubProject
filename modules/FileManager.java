package modules;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void saveUsers(ArrayList<User> users) {

        try {
            FileWriter fw = new FileWriter("Data/users.txt");

            for (User u : users) {
                fw.write(
                        u.id + "," +
                        u.name + "," +
                        u.phone + "," +
                        u.username + "," +
                        u.password + "," +
                        u.role + "\n"
                );
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> list = new ArrayList<>();

        try {
            File file = new File("Data/users.txt");
            if (!file.exists()) return list;

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String phone = data[2];
                String username = data[3];
                String password = data[4];
                String role = data[5];

                if (role.equals("admin"))
                    list.add(new Admin(id, name, phone, username, password));

                else if (role.equals("member"))
                    list.add(new Member(id, name, phone, username, password, "none"));

                else if (role.equals("coach"))
                    list.add(new Coach(id, name, phone, username, password));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        return list;
    }
}
