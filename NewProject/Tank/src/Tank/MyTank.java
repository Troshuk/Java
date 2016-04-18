package Tank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Tank.Game.player;
import static Tank.Game.pointers;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class MyTank {
    public static Tank myTank() throws Exception {
        String name = "";
        int life = 0;
        int attack = 0;
        int armor = 0;
        int points = pointers;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (name.isEmpty()) {
            System.out.println("Введіть імя танка: ");
            name = reader.readLine();
        }
        player = name;

        System.out.println("Розпридільть: " + points + " points по наступним параметрам: життя, атака та броня");

        while (life <= 0 || life >= points - 1) {
            System.out.println("Введіть життя танка від 1 до " + (points - 2) + ": ");
            life = Integer.parseInt(reader.readLine());
        }
        System.out.println("Очків залишилося: " + (points -= life));

        while (attack <= 0 || attack >= points) {
            System.out.println("Введіть атаку танка від 1 до " + (points - 1) + ": ");
            attack = Integer.parseInt(reader.readLine());
        }
        System.out.println("Очків залишилося: " + (points -= attack));

        while (armor <= 0 || armor > points) {
            System.out.println("Введіть броню танка від 1 до " + points + ": ");
            armor = Integer.parseInt(reader.readLine());
        }
        System.out.println("Очків залишилося: " + (points -= armor));

        Tank tank = new Tank(name, life, attack, armor);
        return tank;
    }
}
