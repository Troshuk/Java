package Tank;

import java.util.Random;

import static Tank.Game.pointers;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class EnemyTank {
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
        System.out.print("Противник: ");
        System.out.print("життя: " + life);
        System.out.print("; атака: " + attack);
        System.out.println("; броня: " + armor + ".");

        Tank enemyTank = new Tank(name, life, attack, armor);
        return enemyTank;
    }
}
