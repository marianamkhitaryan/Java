public class Test {
    public static void main(String[] args) {
        Player[] players = new Player[7];
        players[0] = new Player(new CopyCatStrategy());
        players[1] = new Player(new AllyAlwaysStrategy());
        players[2] = new Player(new GrudgerStrategy());
        players[3] = new Player(new RandomStrategy());
        players[4] = new Player(new BetrayAlwaysStrategy());
        players[5] = new Player(new CopyKittenStrategy());
        players[6] = new Player(new DetectiveStrategy());
        ScoreBoard scoreBoard = new ScoreBoard();
        Tournament tournament = new Tournament(10, 100, players, scoreBoard, 0);
        tournament.play();
        tournament.printResults();
    }
}
