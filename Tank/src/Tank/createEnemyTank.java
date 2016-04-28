package Tank;

import java.util.Random;

import static Tank.Game.pointers;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class createEnemyTank {
    public static Tank enemyTank() {
        String name = "EnemyTank";

        int life;
        int attack;
        int armor;
        Random random = new Random();
        int Low = 1;
        int High = pointers;
        life = random.nextInt(High - Low) + Low;
        attack = random.nextInt(High - life - Low) + Low;
        armor = High - life - attack;
        System.out.print("Enemy: ");
        System.out.print("life: " + life);
        System.out.print("; attack: " + attack);
        System.out.println("; armor: " + armor + ".");

        Tank enemyTank = new Tank(name, life, attack, armor);
        return enemyTank;
    }
}
