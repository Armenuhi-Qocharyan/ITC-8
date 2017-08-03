package solder;
import java.lang.*;
public class Solder {
    private String name;
    private String nation;
    private int x; //coordinates
    private int y;
    private int life;

    public Solder(String name, String nation, int x, int y, int life) {
        this.name = name;
        this.nation = nation;
        this.x = x;
        this.y = y;
        this.life = life;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int getLife() {
        return this.life;
    }
    public double getDistance(Solder secondSolder) {
        return Math.sqrt((this.x - secondSolder.getX()) * (this.x - secondSolder.getX()) +
                        (this.y - secondSolder.getY()) * (this.y - secondSolder.getY()));
    }
    public  boolean fire(Solder secondSolder, String weapon, double angle) {
        double realAngle = this.getAngle(secondSolder);
        if (angle == realAngle) {
            switch(weapon) {
                case "gun":
                    secondSolder.life -= 10;
                    break;
                case "carabine":
                    secondSolder.life -= 20;
                    break;
                case "automatic":
                    secondSolder.life -= 30;
                    break;
                default:
                    System.out.println("Undefined weapon " + weapon);
            }
        }
        return secondSolder.isKilled();
    } 
    private boolean isKilled() {
        return life <= 0 ? true : false;
    }
    public double getAngle(Solder secondSolder) {
        return Math.asin(Math.abs(this.x - secondSolder.getX()) / this.getDistance(secondSolder));
    }
}