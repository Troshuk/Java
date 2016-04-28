package Tank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Tank.Game.player;
import static Tank.Game.pointers;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class createPlayerTank {
    public static Tank myTank() throws Exception {
        String name = "";
        int life = 0;
        int attack = 0;
        int armor = 0;
        int points = pointers;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (name.isEmpty()) {
            System.out.println("Enter the name of the tank: ");
            name = reader.readLine();
        }
        player = name;

        System.out.println("Distribute: " + points + " \"points\" on the following parameters: life, armor and attack");

        while (life <= 0 || life >= points - 1) {
            System.out.println("Enter life the tank 1 to " + (points - 2) + ": ");
            life = Integer.parseInt(reader.readLine());
        }
        System.out.println("Points to:" + (points -= life));

        while (attack <= 0 || attack >= points) {
            System.out.println("Enter attack the tank 1 to " + (points - 1) + ": ");
            attack = Integer.parseInt(reader.readLine());
        }
        System.out.println("Points to:" + (points -= attack));

        while (armor <= 0 || armor > points) {
            System.out.println("Enter armor the tank 1 to " + points + ": ");
            armor = Integer.parseInt(reader.readLine());
        }
//        System.out.println("Points to:" + (points -= armor));

        Tank tank = new Tank(name, life, attack, armor);
        return tank;
    }
}
