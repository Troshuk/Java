package Tank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static Tank.Game.POINTERS;

public class CreatePlayerTank {
    public static Tank createTank() throws Exception {
        String name = "Tintin";
        int life = 100;
        int attack = 100;
        int armor = 100;
        int points = POINTERS;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (name.isEmpty()) {
            System.out.println("Enter the name of the tank: ");
            name = reader.readLine();
        }

        System.out.printf("Distribute: %d \"points\" on the following parameters: life, armor and attack%n", points);

        while (life <= 0 || life >= points - 1) {
            System.out.printf("Enter life the tank 1 to %d: %n", points - 2);
            life = Integer.parseInt(reader.readLine());
        }
        System.out.printf("Points to:%d%n", points -= life);

        while (attack <= 0 || attack >= points) {
            System.out.printf("Enter attack the tank 1 to %d: %n", points - 1);
            attack = Integer.parseInt(reader.readLine());
        }
        System.out.printf("Points to:%d%n", points -= attack);

        while (armor <= 0 || armor > points) {
            System.out.printf("Enter armor the tank 1 to %d: %n", points);
            armor = Integer.parseInt(reader.readLine());
        }

        return new Tank(name, life, attack, armor);
    }
}
