package modules;

import java.util.ArrayList;

public class User {

    // دي بيانات اليوزر الأساسية اللي كل الكلاسات التانية هتورثها
    protected int id;           // رقم تعريفي لكل يوزر
    protected String name;      // اسم اليوزر
    protected String phone;     // رقم الموبايل
    protected String username;  // اسم المستخدم اللي بيدخل بيه
    protected String password;  // الباسوورد اللي بيدخل بيه
    protected String role;      // نوع اليوزر (admin / member / coach)

    // دا الصندوق اللي بيتخزن فيه كل الإشعارات اللي بتوصل للمستخدم
    protected ArrayList<Notification> inbox = new ArrayList<>();


    // دا الكونستركتور اللي بيستقبل بيانات اليوزر أول ما بنعمله Create
    public User(int id, String name, String phone, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    // دا بيعمل تسجيل دخول
    // بيشيّك هل اليوزر والباسورد اللي اتكتبوا مطابقين للبيانات اللي عندي ولا لأ
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }


    // دي بتحدث بيانات اليوزر (اسم + موبايل)
    // لو اليوزر عايز يعدّل بياناته بعد تسجيل الدخول
    public void updateInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    // دي وظيفتها تضيف إشعار جديد للـ inbox بتاع اليوزر
    public void sendNotification(Notification n) {
        inbox.add(n);
    }


    // دي بتعرض كل الإشعارات اللي وصلت للمستخدم
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


    // دي بتعرض بيانات اليوزر الأساسية
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Role: " + role);
    }
}
