package modules;

public class Member extends User {
    //Tarek code                            

    private String subscription;

    public Member(int id, String name, String phone, String username, String password, String subscription) {
        super(id, name, phone, username, password, "member");
        this.subscription = subscription;
    }

    public void showSubscription() {
        System.out.println("Subscription: " + subscription);
    }
}
