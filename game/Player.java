public class Player {
    
    private Strategy strategy;
    private int score;

    public Player (Strategy s){
        this.strategy = s;
        score = 0;
    }

    public Player (Player player) {
        this.strategy = player.strategy;
        this.score = player.score;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public int getScore() {
        return score;
    }

    public void setStrategy(Strategy s) {
        this.strategy = s;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public Strategy.Move makeMistake(Strategy.Move move, double mistakeChance) {
        if (Math.random() < mistakeChance) {
            if(move == Strategy.Move.ALLY) {
                return Strategy.Move.BETRAY;
            } else {
                return Strategy.Move.ALLY;
            }
        }
        return move;
    }

}
