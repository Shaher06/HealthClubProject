import modules.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // بنعمل object من ال UserManager 
        // علشان هو المسؤول عن إدارة كل اليوزرز (تسجيل دخول - إضافة - تخزين)
        UserManager um = new UserManager();

        // تحميل كل المستخدمين من الملف users.txt
        // أول ما البرنامج يشتغل
        um.getAllUsers().addAll(FileManager.loadUsers());

        // لو دي أول مرة المشروع يتفتح ومفيش أي يوزرز
        // بنعمل Admin افتراضي يدخل منه التيم
        if (um.getAllUsers().isEmpty()) {
            System.out.println("No users found. Creating default admin...");
            um.addUser(new Admin(1, "Admin", "0100", "admin", "1234"));
            FileManager.saveUsers(um.getAllUsers()); 
        }

        Scanner sc = new Scanner(System.in);

        // واجهة تسجيل الدخول
        System.out.println("=== Health Club Login ===");
        System.out.print("Username: ");
        String u = sc.nextLine();
        System.out.print("Password: ");
        String p = sc.nextLine();

        // تسجيل الدخول بواسطة ال UserManager
        // لو اليوزر والباسورد صح → يرجّع User object
        // لو غلط → يرجّع null
        User logged = um.login(u, p);

        // لو مفيش يوزر مطابق
        if (logged == null) {
            System.out.println("Login failed. Wrong username or password.");
            return; // نخرج من البرنامج
        }

        System.out.println("Login successful!");
        System.out.println("Welcome " + logged.name + " (" + logged.role + ")");

        // توجيه المستخدم حسب نوعه (Role)
        // Admin → Admin Menu
        // Member → Member Menu
        // Coach → Coach Menu
        switch (logged.role) {

            case "admin":
                System.out.println("Admin menu loading...");
                logged.showInfo();
                // هنا التيم هيحط ال AdminMenu
                break;

            case "member":
                System.out.println("Member menu loading...");
                logged.showInfo();
                // هنا التيم هيحط ال MemberMenu
                break;

            case "coach":
                System.out.println("Coach menu loading...");
                logged.showInfo();
                // وهنا ال CoachMenu
                break;
        }

        // قبل ما البرنامج يقفل
        // بنحفظ اليوزرز تاني في الملف بعد أي تغييرات
        FileManager.saveUsers(um.getAllUsers());
    }
}
