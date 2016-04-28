package Tank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Progr@mist on 19.04.2016.
 */
public class SaveToFile {
    public static void saveToFile(String play, int round, boolean winOrLose) throws IOException {
        File file = new File("res//result.txt");
        if (!file.exists()) file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
        int q;
        int w;
        if (winOrLose) {
            q = 1;
            w = 0;
        } else {
            q = 0;
            w = 1;
        }
        boolean findPlayers = false;
        byte[] content = new byte[fis.available()];
        fis.read(content);
        String[] lines = new String(content, "UTF-8").split("\n");
        String finder = "";
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (word.equalsIgnoreCase(String.format("(%s)", play))) {
                    finder = line;
                    findPlayers = true;
                }
            }
        }
        if (findPlayers) {
            int win = finder.lastIndexOf("Wins: ") + 6;
            String fis1 = finder;
            String s = fis1.substring(win);
            String lom = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ';') break;
                lom += s.charAt(i);
            }
            q += Integer.parseInt(lom);

            int lose = finder.lastIndexOf("Losses: ") + 8;
            String fis2 = finder;
            String s1 = fis2.substring(lose);
            String lom1 = "";
            for (int i = 0; i < s.length(); i++) {
                if (s1.charAt(i) == '.') break;
                lom1 += s1.charAt(i);
            }
            w += Integer.parseInt(lom1);
        }
            String text = String.format("(%s) Rounds played: %d; Wins: %d; Losses: %d.", play, round, q, w);
            FileWriter resultat = new FileWriter(file, true);
            resultat.write(String.format("%s\r\n\r\n", text));
            resultat.flush();
    }
}
