package patterns.behavior.chain;

public interface Handler {
    void process(Request request);
    boolean canProcess(Request request);
}
