package patterns.structure.decorator;

public class MessengerDecorator extends BaseNotifier {
    public MessengerDecorator(INotifier wrapped){
        super(wrapped);
    }
    @Override
    public void send(String msg){
        super.send(msg);
        System.out.println("Sending via messenger");
    }

}
