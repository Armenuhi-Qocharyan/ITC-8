package soldiery;
import java.util.*;
import interfaces.Soldier;
import objs.*;

public class Ordinary implements Soldier {
    public int _x;
    public int _y;
    public String _name;
    public String _nationality;
    public int _life;
    
    public Ordinary() {
        this._x = 0;
        this._y = 0;
        this._name = "";
        this._nationality = "";
        this._life = 0;
    }

    public String getName() {
        return this._name;
    }

    public int getLife() {
        return this._life;
    }

    public void setLife(int life) {
        this._life = life;
    }


    public Objs initialize () {
        System.out.print("Enter soldier coordinates:\nx = ");
        Scanner scan =  new Scanner(System.in);
        this._x = scan.nextInt();
        System.out.print("y = ");
        this._y = scan.nextInt();
        Scanner scanLine = new Scanner(System.in);
        System.out.print("Enter soldier name: ");
        this._name = scanLine.nextLine();        
        System.out.print("Enter soldier nationality: ");
        this._nationality = scanLine.nextLine();
        System.out.print("Enter soldier life: ");
        this._life = scan.nextInt();
        Objs ball = new Objs(this._x, this._y, 0, 0, 10, this._name);
        return ball;
    }

    public void move () {
        System.out.print("Enter soldier new coordinates:\nx = ");
        Scanner scan =  new Scanner(System.in);
        this._x = scan.nextInt();
        System.out.print("y = ");
        this._y = scan.nextInt();
    }

    public void fire(Meadow meadow, ArrayList<Soldier> soldier) {
        Scanner scan =  new Scanner(System.in);
        System.out.print("Enter the shot angle:\nangle = ");
        int angle = scan.nextInt();
        System.out.print("\nEnter the weapon:\npistol - 1\nak-47 - 2\ngrenade - 3\nweapon = ");
        int weapon = scan.nextInt();
        if(weapon > 5 || weapon < 1) {
            System.out.println("Wrong weapon");
            return;
        }
        Objs bullet = new Objs(this._x, this._y, angle, 30, 1, "");
        Objs shoter = meadow.getObjectByName(this._name);
        if(shoter != null) {
            if(meadow.shot(this, bullet, shoter, weapon, soldier)) {
                System.out.println("You hit the target");
            } else {
                System.out.println("You missed");
            }
        }
    }
}
