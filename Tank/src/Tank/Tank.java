package Tank;

/**
 * Created by Progr@mist on 18.04.2016.
 */
public class Tank {
    private String name;
    private int life;
    private int attack;
    private int armor;

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getName() {

        return name;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public Tank(String name, int life, int attack, int armor) {
        this.name = name;

        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }
}
