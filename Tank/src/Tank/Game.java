package Tank;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Game {
    public static int rounds;
    public static int pointers = 300;
    public static String player;

    public static void main(String[] args) throws Exception {
        String winner = War(createPlayerTank.myTank(), createEnemyTank.enemyTank());
        System.out.println("Winner: " + winner + "!");
        System.out.println(Win(winner == player));
        SaveToFile.saveToFile(player, rounds, winner == player);
    }

    public static String Win(boolean b) {
        String s = "YOU ";
        if (b) return s + "WIN!!!";
        else return s + "LOSE :(";
    }

    public static String War(Tank my, Tank enemy) {
        while (true) {
            if (enemy.getLife() <= 0 || my.getLife() <= 0) break;

            int b = (pointers - (pointers / enemy.getAttack())) / 20;
            if (enemy.getAttack() > my.getArmor()) b += 5;
//            int lo = my.getLife();
            my.setLife(b);
            if (my.getLife() <= 0) my.setLife(0);
//            System.out.println("My health: " + lo + "-" + b + "=" + my.getLife());
            rounds++;

            if (my.getLife() <= 0) return enemy.getName();
            int a = (pointers - (pointers / my.getAttack())) / 20;
            if (my.getAttack() > enemy.getAttack()) a += 5;
//            int lol = enemy.getLife();
            enemy.setLife(enemy.getLife() - a);
            if (enemy.getLife() <= 0) enemy.setLife(0);
//            System.out.println("Enemy health: " + lol + "-" + a + "=" + enemy.getLife());
        }
        if (my.getLife() > enemy.getLife()) return my.getName();
        else return enemy.getName();
    }
}
