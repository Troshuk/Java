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
        int points = pointers;
        Random random = new Random();
        life = random.nextInt(++points);
        attack = random.nextInt(points -= life + 1);
        armor = points -= attack;
        System.out.println("Противник: ");
        System.out.print("життя: " + life);
        System.out.print("; атака: " + attack);
        System.out.println("; броня: " + armor);

        Tank enemyTank = new Tank(name, life, attack, armor);
        return enemyTank;
    }
}
