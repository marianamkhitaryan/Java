public class ScoreBoard {
    
    private int aa;
    private int ab;
    private int ba;
    private int bb;

    public ScoreBoard() {
        aa = 2;
        ab = -1;
        ba = 3; 
        bb = 0;
    }

    public ScoreBoard(int aa, int ab, int ba, int bb) {
        this.aa = aa; 
        this.ab = ab; 
        this.ba = ba; 
        this.bb = bb; 
    }

    public ScoreBoard(ScoreBoard scoreBoard) {
        this.aa = scoreBoard.aa; 
        this.ab = scoreBoard.ab; 
        this.ba = scoreBoard.ba; 
        this.bb = scoreBoard.bb; 
    }

    public int getaa(int aa) {
        return aa;
    }

    public int getab(int ab) {
        return ab;
    }

    public int getba(int ba) {
        return ba;
    }

    public int getbb(int bb) {
        return bb;
    }

    //setters

    public int getScore (Strategy.Move move, Strategy.Move opponentMove) {
        if(move == Strategy.Move.ALLY && opponentMove == Strategy.Move.ALLY) {
            return aa;
        } else if(move == Strategy.Move.ALLY && opponentMove == Strategy.Move.BETRAY) {
            return ab;
        } else if(move == Strategy.Move.BETRAY && opponentMove == Strategy.Move.ALLY) {
            return ba;
        } 
        return bb;
    }

}
