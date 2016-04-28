package Tank;

import java.util.Random;

import static Tank.Game.POINTERS;

public class CreateEnemyTank {
    public static Tank enemyTank() {
        String name = "EnemyTank";
        int Low = 1;
        Random random = new Random();
        int life = random.nextInt(POINTERS - Low) + Low;
        int attack = random.nextInt(POINTERS - life - Low) + Low;
        int armor = POINTERS - life - attack;
        System.out.print("Enemy: ");
        System.out.printf("life: %d", life);
        System.out.printf("; attack: %d", attack);
        System.out.printf("; armor: %d.%n", armor);
        return new Tank(name, life, attack, armor);
    }
}
