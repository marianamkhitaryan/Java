public class CopyCatStrategy extends ComplexStrategy{
 
    public Move act() {
        Move prevOpponentMove = getPrevOpponentMove();
        if(prevOpponentMove == null || prevOpponentMove == Move.ALLY) {
            return Move.ALLY;
        } 
        return Move.BETRAY;
    }

    public String toString() {
        return "CopyCatStrategy";
    }

}
