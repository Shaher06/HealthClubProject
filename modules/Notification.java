package modules;

import java.time.LocalDateTime;

public class Notification {

    // دا النص اللي هيظهر للمستخدم داخل الإشعار
    // مثال: "اشتراكك سينتهي خلال 3 أيام"
    private String message;

    // دا التاريخ والوقت اللي الإشعار اتبعت فيهم
    // بيتسجل تلقائي وقت إنشاء الإشعار
    private LocalDateTime date;

    // دا اسم اللي بعت الإشعار
    // ممكن يكون Admin – Coach – System
    private String sender;


    // دا الكونستركتور اللي بينشئ إشعار جديد
    // بياخد الرسالة والمرسل من المنيو اللي هيبعتها
    // وبياخد الوقت الحالي بشكل أوتوماتيك
    public Notification(String message, String sender) {
        this.message = message;   // يحفظ الرسالة
        this.sender = sender;     // يحفظ اسم المرسل
        this.date = LocalDateTime.now(); // يسجل وقت الإرسال
    }


    // دي بتجيب نص الرسالة علشان نعرضها للمستخدم
    public String getMessage() { 
        return message; 
    }

    // دي بتجيب اسم المرسل علشان يظهر في inbox
    public String getSender() { 
        return sender; 
    }

    // دي بترجع التاريخ اللي اتبعت فيه الإشعار
    public LocalDateTime getDate() { 
        return date; 
    }
}
