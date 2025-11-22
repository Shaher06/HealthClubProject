package modules;

import java.util.ArrayList;

public class UserManager {

    // دي الليست الأساسية اللي بنخزن فيها كل اليوزرز اللي موجودين في النظام
    // سواء كانوا Admin أو Member أو Coach
    private ArrayList<User> users = new ArrayList<>();

    // دي بترجع الليست كلها علشان تتخزن في ملف لما نعمل save
    // أو لو حد في المشروع محتاج يشوف كل اليوزرز
    public ArrayList<User> getAllUsers() { 
        return users;
    }

    // دي وظيفة إضافة يوزر جديد للنظام
    // التيم هيستخدمها لما الادمن يضيف Member أو يضيف Coach
    public void addUser(User u) {
        users.add(u);
    }

    // دي وظيفة تسجيل الدخول
    // بتلف على كل اليوزرز وتشيّك هل اليوزر والباسورد اللي اتكتبوا صح ولا لأ
    // لو لقت يوزر مطابق → بترجعه
    // لو مفيش حد مطابق → بترجع null
    public User login(String username, String password) {
        for (User u : users) {

            // ال login هنا اللي جوّا User class نفسه
            if (u.login(username, password)) { 
                return u; // لو لقى يوزر صح بيرجعه
            }
        }
        return null; // لو مفيش ولا واحد مظبوط
    }
}

