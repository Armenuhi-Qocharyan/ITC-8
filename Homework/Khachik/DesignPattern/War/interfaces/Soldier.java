package interfaces;
import java.util.ArrayList;
import java.util.Scanner;
import objs.Meadow;
import objs.Objs;

public abstract class Soldier {
    public int _x = 0;
    public int _y = 0;
    public int _life = 0;
    public String _name = "";
    public String _nationality = "";
 
    public Soldier() {
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

    public Objs initialize (int radius) {
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
        Objs ball = new Objs(this._x, this._y, 0, 0, radius, this._name);
        return ball;
    }

    public void move () {
        System.out.print("Enter soldier new coordinates:\nx = ");
        Scanner scan =  new Scanner(System.in);
        this._x = scan.nextInt();
        System.out.print("y = ");
        this._y = scan.nextInt();
    }
    
    public abstract void fire(Meadow meadow, ArrayList<Soldier> soldier); 
}
