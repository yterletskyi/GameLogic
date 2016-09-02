package yura;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        int wonScores = game.spin(3);
        System.out.println(wonScores);
    }
}
