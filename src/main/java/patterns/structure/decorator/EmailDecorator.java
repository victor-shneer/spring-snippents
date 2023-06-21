package patterns.structure.decorator;

public class EmailDecorator extends BaseNotifier {
    public EmailDecorator(INotifier wrapped){
        super(wrapped);
    }
    @Override
    public void send(String msg){
        super.send(msg);
        System.out.println("Sending via email");
    }

}
