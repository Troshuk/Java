package Tank;

import java.util.Random;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Game {
    public static int score = 0;
    public static int pointers = 300;
    public static String player = "";

    public static void main(String[] args) {
        String winner = War(myTank(), enemyTank());
        printResult(winner);
        System.out.println(Win(winner == player));
        System.out.println("Раундів зіграно: " + score);
    }

    private static void printResult(String p) {
        System.out.println("Переможець: " + p);
    }

    public static Tank myTank() {
        String name;
        int life;
        int attack;
        int armor;
        name = "Мій танчик";
        player = name;
        int points = pointers;
        System.out.println("Введіть імя танка: " + name);

        System.out.println("Розпридільть: " + points + " points по наступним параметрам: життя, атака та броня");

        life = 80;
        System.out.println("Введіть життя танка: " + life);
        System.out.println("Очків для розприділення доступно: " + (points -= life));

        attack = 120;
        System.out.println("Введіть атаку танка: " + attack);
        System.out.println("Очків для розприділення доступно: " + (points -= attack));

        armor = 100;
        System.out.println("Введіть броню танка: " + armor);
        System.out.println("Очків для розприділення доступно: " + (points -= armor));

        Tank tank = new Tank(name, life, attack, armor);
        return tank;
    }

    public static Tank enemyTank() {
        String name = "EnemyTank";

        int life;
        int attack;
        int armor;
        int points = pointers;
        Random random = new Random();
        System.out.println(life = random.nextInt(points));
        System.out.println(attack = random.nextInt(points -= life));
        System.out.println(armor = points -= attack);

        Tank enemyTank = new Tank(name, life, attack, armor);
        return enemyTank;
    }

    public static String War(Tank my, Tank enemy) {
        while (true) {
            if (enemy.life <= 0 || my.life <= 0) break;

            int b = (my.armor * 100 / enemy.attack) / 10;
            if (enemy.attack > my.armor) b *= 2;
            my.life -= b;
            if (my.life <= 0) my.life = 0;
            System.out.println("Моє здоровя: " + my.life);
            score++;

            if (my.life <= 0) return enemy.name;

            int a = (enemy.armor * 100 / my.attack) / 10;
            if (my.attack > enemy.armor) a *= 2;
            enemy.life -= a;
            if (enemy.life <= 0) enemy.life = 0;
            System.out.println("Здоровя ворога: " + enemy.life);
        }
        if (my.life > enemy.life) return my.name;
        else return enemy.name;
    }

    public static String Win(boolean b) {
        String s = "YOU ";
        if (b) return s + "WIN!!!";
        else return s + "LOSE :(";
    }
}
