package Tank;

import static Tank.Game.pointers;
import static Tank.Game.score;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class War {
    public static String War(Tank my, Tank enemy) {
        while (true) {
            if (enemy.life <= 0 || my.life <= 0) break;

            int b = (pointers - (pointers / enemy.attack)) / 20;
            if (enemy.attack > my.armor) b += 5;
            int lo = my.life;
            my.life -= b;
            if (my.life <= 0) my.life = 0;
//            System.out.println("Моє здоровя: " + lo + "-" + b + "=" + my.life);
            score++;

            if (my.life <= 0) return enemy.name;
            int a = (pointers - (pointers / my.attack)) / 20;
            if (my.attack > enemy.armor) a += 5;
            int lol = enemy.life;
            enemy.life -= a;
            if (enemy.life <= 0) enemy.life = 0;
//            System.out.println("Здоровя ворога: " + lol + "-" + a + "=" + enemy.life);
        }
        if (my.life > enemy.life) return my.name;
        else return enemy.name;
    }
}
