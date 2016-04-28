package Tank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
    public static void saveToFile(String play, int round, boolean winOrLose) throws IOException {
        File file = new File("res//result.txt");
        if (!file.exists()) file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
        int win;
        int lose;
        if (winOrLose) {
            win = 1;
            lose = 0;
        } else {
            win = 0;
            lose = 1;
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
            int indexWinsPoints = finder.lastIndexOf("Wins: ") + 6;
            String searchWinPoints = finder;
            String cutString1 = searchWinPoints.substring(indexWinsPoints);
            String winsPoints = "";
            for (int i = 0; i < cutString1.length(); i++) {
                if (cutString1.charAt(i) == ';') break;
                winsPoints += cutString1.charAt(i);
            }
            win += Integer.parseInt(winsPoints);

            int indexLosesPoints = finder.lastIndexOf("Losses: ") + 8;
            String searchLosePoints = finder;
            String cutString2 = searchLosePoints.substring(indexLosesPoints);
            String losesPoints = "";
            for (int i = 0; i < cutString1.length(); i++) {
                if (cutString2.charAt(i) == '.') break;
                losesPoints += cutString2.charAt(i);
            }
            lose += Integer.parseInt(losesPoints);
        }
        String text = String.format("(%s) Rounds played: %d; Wins: %d; Losses: %d.", play, round, win, lose);
        FileWriter resultat = new FileWriter(file, true);
        resultat.write(String.format("%s\r\n\r\n", text));
        resultat.flush();
    }
}
