package Tank;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Game {
    public static int rounds;
    public static int pointers = 300;
    public static String player;

    public static void main(String[] args) throws Exception {
        String winner = fight(СreatePlayerTank.playerTank(), СreateEnemyTank.enemyTank());
        System.out.println("Winner: " + winner + "!");
        System.out.println(createWinResult(winner == player));
        SaveToFile.saveToFile(player, rounds, winner == player);
    }

    private static String createWinResult(boolean b) {
        String s = "YOU ";
        if (b) return s + "WIN!!!";
        else return s + "LOSE :(";
    }

    private static String fight(Tank player, Tank enemy) {
        while (true) {
            if (enemy.getLife() <= 0 || player.getLife() <= 0) break;

            int b = (pointers - (pointers / enemy.getAttack())) / 20;
            if (enemy.getAttack() > player.getArmor()) b += 5;
//            int lo = player.getLife();
            player.setLife(b);
            if (player.getLife() <= 0) player.setLife(0);
//            System.out.println("My health: " + lo + "-" + b + "=" + player.getLife());
            rounds++;

            if (player.getLife() <= 0) return enemy.getName();
            int a = (pointers - (pointers / player.getAttack())) / 20;
            if (player.getAttack() > enemy.getAttack()) a += 5;
//            int lol = enemy.getLife();
            enemy.setLife(enemy.getLife() - a);
            if (enemy.getLife() <= 0) enemy.setLife(0);
//            System.out.println("Enemy health: " + lol + "-" + a + "=" + enemy.getLife());
        }
        if (player.getLife() > enemy.getLife()) return player.getName();
        else return enemy.getName();
    }
}
