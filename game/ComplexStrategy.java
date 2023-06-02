public class ComplexStrategy extends Strategy{
    
    private Move prevOpponentMove;

    public Move getPrevOpponentMove() {
        return prevOpponentMove;
    }

    public void setPrevOpponentMove(Move prevOpponentMove) {
        this.prevOpponentMove = prevOpponentMove;
    }

    public void reset() {
        prevOpponentMove = null;
    }
}
