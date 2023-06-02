public class StrategyRandom extends SimpleStrategy{
    
    public Move act() {
        return Math.random() > 0.5 ? Move.ALLY : Move.BETRAY;
    }

    public String toString() {
        return "StrategyRandom";
    }
}
