public class Strategy {

    protected enum Move {
        ALLY, BETRAY
    }

    public Move act() {
        return Move.ALLY;
    }

}