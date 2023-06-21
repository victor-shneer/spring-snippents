package patterns.behavior.chain;

public class ConcreteHandler implements Handler {

    @Override
    public void process(Request request) {
        request.getContent(); //process!
    }

    @Override
    public boolean canProcess(Request request) {
        return !request.getContent().isEmpty();
    }
}
