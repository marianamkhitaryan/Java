public class BetrayAlwaysStrategy extends SimpleStrategy{

    public Move act() {
        return Move.BETRAY;
    }

    public String toString() {
        return "BetrayAlwaysStrategy";
    }
    
}
