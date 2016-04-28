package Tank;

import java.util.Random;

import static Tank.Game.pointers;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class СreateEnemyTank {
    public static Tank enemyTank() {
        String name = "EnemyTank";
        int Low = 1;
        int High = pointers;
        Random random = new Random();
        int life = random.nextInt(High - Low) + Low;
        int attack = random.nextInt(High - life - Low) + Low;
        int armor = High - life - attack;
        System.out.print("Enemy: ");
        System.out.print("life: " + life);
        System.out.print("; attack: " + attack);
        System.out.println("; armor: " + armor + ".");

        return new Tank(name, life, attack, armor);
    }
}
