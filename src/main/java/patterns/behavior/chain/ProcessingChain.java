package patterns.behavior.chain;

import java.util.Arrays;
import java.util.List;

public class ProcessingChain {
    private List<Handler> handlerList;

    public ProcessingChain(Handler... handlers){
        this.handlerList = Arrays.asList(handlers);
    }

    public void execute(Request request){
        for(Handler handler: handlerList){
            if(handler.canProcess(request)){
                handler.process(request);
                break;
            }
        }
    }
}
