package patterns.structure.decorator;

public class Notifier implements INotifier {
    private final String username;

    public Notifier(String username) {
        this.username = username;
    }

    public void send(String msg){
        System.out.println("Sending notification for " + username);
    }

    public String getUsername(){
        return username;
    }
}
