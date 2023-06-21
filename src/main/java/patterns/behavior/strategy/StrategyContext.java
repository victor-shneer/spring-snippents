package patterns.behavior.strategy;

public class StrategyContext {


    private Strategy strategy; // can be any concrete strategy that implements Strategy

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int[] executeStrategy(int[] array){
        return strategy.sort(array);
    }
}
