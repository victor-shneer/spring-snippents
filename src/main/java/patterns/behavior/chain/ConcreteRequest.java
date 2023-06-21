package patterns.behavior.chain;

import lombok.Data;

public class ConcreteRequest implements Request{
    private final String content;

    public ConcreteRequest(String content){
        this.content = content;
    }
    @Override
    public String getContent() {
        return content;
    }
}
