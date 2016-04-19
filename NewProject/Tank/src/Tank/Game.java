package Tank;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Game {
    public static int rounds;
    public static int pointers = 300;
    public static String player;

    public static void main(String[] args) throws Exception {
        String winner = War.War(MyTank.myTank(), EnemyTank.enemyTank());
        System.out.println("Переміг: " + winner + "!");
        System.out.println(Win(winner == player));
        SaveToFile.saveToFile(player, rounds, winner == player);
    }

    public static String Win(boolean b) {
        String s = "YOU ";
        if (b) return s + "WIN!!!";
        else return s + "LOSE :(";
    }
}
