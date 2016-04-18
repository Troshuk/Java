package Tank;

import java.io.*;
import java.util.Random;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Game {
    public static int score;
    public static int pointers = 300;
    public static String player;
    public static void main(String[] args) throws Exception {
        String winner = War.War(MyTank.myTank(), EnemyTank.enemyTank());
        printResult(winner);
        System.out.println("Раундів зіграно: " + score);
        System.out.println("Переміг: " + winner + "! Кількість зіграних раундів: " + score);
        System.out.println(Win(winner == player));
        saveToFile("Переміг: " + winner + "! Кількість зіграних раундів: " + score);
        saveToFile(Win(winner == player));
        saveToFile("");
    }

    private static void saveToFile(String text) throws IOException {
        File file = new File("res//result.txt");
        if (!file.exists()) file.createNewFile();
        FileWriter resultat = new FileWriter(file, true);
        resultat.write(text + "\r\n\r");
        resultat.flush();
    }

    private static void printResult(String p) {
        System.out.println();
        System.out.println("Переможець: " + p);
    }

    public static String Win(boolean b) {
        String s = "YOU ";
        if (b) return s + "WIN!!!";
        else return s + "LOSE :(";
    }
}
