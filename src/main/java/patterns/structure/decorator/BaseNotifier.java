package patterns.structure.decorator;

public abstract class BaseNotifier implements INotifier{
    private final INotifier wrapped;
    protected final String dataBaseService;

    BaseNotifier(INotifier wrapped){
        this.wrapped = wrapped;
        dataBaseService = "db";
    }

    @Override
    public void send(String msg){
        wrapped.send(msg);
    }

    @Override
    public String getUsername(){
        return wrapped.getUsername();
    }
}
