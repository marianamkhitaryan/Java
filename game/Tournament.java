public class Tournament {
    
    private int matchNumber;
    private int roundNumber;
    private Player[] players;
    private ScoreBoard scoreBoard;
    private double mistakeChance;

    //TODO: getters setters

    public Tournament(int matchNumber, int roundNumber, Player[] players, ScoreBoard scoreBoard, double mistakeChance) {
        this.matchNumber = matchNumber;
        this.roundNumber = roundNumber;
        this.players = new Player[players.length];
        for(int i = 0; i < players.length; i++) {
            this.players[i] = new Player(players[i]);
        }
        this.scoreBoard = new ScoreBoard(scoreBoard);
        this.mistakeChance = mistakeChance;
    }

    public void play() {
        for (int i = 0; i < matchNumber; i++) {
            for (int p1 = 0; p1 < players.length; p1++) {
                for (int p2 = p1 + 1; p2 < players.length; p2++) {
                    play(players[p1], players[p2], roundNumber);
                }
            }
        }
    }

    public void play(Player one, Player two, int rounds) {
        Strategy s1 = one.getStrategy();
        Strategy s2 = two.getStrategy();
        for (int i = 0; i < rounds; i++) {
            Strategy.Move oneMove = one.makeMistake(s1.act(), mistakeChance);
            Strategy.Move twoMove = two.makeMistake(s2.act(), mistakeChance);

            if (s1 instanceof ComplexStrategy) {
                ((ComplexStrategy) s1).setPrevOpponentMove(twoMove);
            }
            if (s2 instanceof ComplexStrategy) {
                ((ComplexStrategy) s2).setPrevOpponentMove(oneMove);
            }

            one.addToScore(scoreBoard.getScore(oneMove, twoMove));
            two.addToScore(scoreBoard.getScore(twoMove, oneMove));
        }

        if (s1 instanceof ComplexStrategy) {
            ((ComplexStrategy) s1).reset();
        }
        if (s2 instanceof ComplexStrategy) {
            ((ComplexStrategy) s2).reset();
        }
    }

    public void printResults() {

        for (int i = 0; i < players.length; i++) {
            System.out.println("Playerr #" + (i+1));
            System.out.println("Strategy " + players[i].getStrategy());
            System.out.println("Score " + players[i].getScore());
        }
    }
}
