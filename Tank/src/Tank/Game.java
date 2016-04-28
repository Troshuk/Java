package Tank;

public class Game {
    public static int rounds;
    public static final int POINTERS = 300;

    public static void main(String[] args) throws Exception {
        Tank playerTank = CreatePlayerTank.createTank();
        String userName = playerTank.getName();
        String winner = fight(playerTank, CreateEnemyTank.enemyTank());
        System.out.printf("Winner: %s! ", winner);
        System.out.println(createWinResult(winner.equals(userName)));
        SaveToFile.saveToFile(userName, rounds, winner.equals(userName));
    }

    private static String createWinResult(boolean isWinner) {
        return String.format("YOU %s", isWinner ? "Win" : "Lose");
    }

    private static String fight(Tank player, Tank enemy) {

        while (true) {
            if (enemy.getLife() <= 0 || player.getLife() <= 0) {
                break;
            }
            int enemyDamage = (POINTERS - (POINTERS / enemy.getAttack())) / 20;
            if (enemy.getAttack() > player.getArmor()) {
                enemyDamage += 5;
            }
            player.setLife(player.getLife() - enemyDamage);
            if (player.getLife() <= 0) {
                player.setLife(0);
            }
            rounds++;

            if (player.getLife() <= 0) {
                return enemy.getName();
            }
            int playerDamage = (POINTERS - (POINTERS / player.getAttack())) / 20;
            if (player.getAttack() > enemy.getArmor()) {
                playerDamage += 5;
            }
            enemy.setLife(enemy.getLife() - playerDamage);
            if (enemy.getLife() <= 0) {
                enemy.setLife(0);
            }
        }
        return player.getLife() > enemy.getLife() ? player.getName() : enemy.getName();
    }
}
