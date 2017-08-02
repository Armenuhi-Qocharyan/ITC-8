package war;
import java.lang.Math;

public class Soldier {
    private String name;
    private String nation;
    private int life;
    private int x;
    private int y;
    private Weapon weapon;
    private int size;
    
    public Soldier(String name, String nation, int life, Weapon weapon, int size) {
        this.name = name;
        this.nation = nation;
        this.life = life;
        this.x = weapon.getBullet().getX();
        this.y = weapon.getBullet().getY();
        this.weapon = weapon;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getNation() {
        return this.nation;
    }

    public void setLife(int life) {
        this.life = life;
    }
    public int getLife() {
        return this.life;
    }

    public void setCoordX(int x) {
        this.x = x;
    }
    public int getCoordX() {
        return this.x;
    }
    public void setCoordY(int y) {
        this.y = y;
    }
    public int getCoordY() {
        return this.y;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
   
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }

    public boolean fire(Soldier soldier, int angle) {
        int newX = 0, newY = 0;
        for(int i = 0; i < this.weapon.getDiapason() / this.weapon.getSpeed(); ++i) {
            newX = (int)(this.weapon.getSpeed() * Math.sin(Math.toRadians(angle)));
            this.weapon.getBullet().setMoveX(newX); 
            newY = (int)(this.weapon.getSpeed() * Math.cos(Math.toRadians(angle)));
            this.weapon.getBullet().setMoveY(newY); 
            if(this.check(soldier)) {
                soldier.life -= this.weapon.getDamage();
                return true;
            }
        }
        return false;
    }

    public boolean check(Soldier soldier) {
         return (Math.sqrt((this.weapon.getBullet().getMoveX() - soldier.x) * (this.weapon.getBullet().getMoveX() - soldier.x) + (this.weapon.getBullet().getMoveY() - soldier.y) * (this.weapon.getBullet().getMoveY() - soldier.x)) <= this.weapon.getBullet().getSize() + soldier.size);
    }

    public void printSoldierInfo() {
        System.out.println("Soldier Name           : " + this.name);
        System.out.println("Soldier Nationality    : " + this.nation);
        System.out.println("Soldier Life           : " + this.life);    
        System.out.println("Soldier coordinate X   : " + this.x);
        System.out.println("Soldier coordinate Y   : " + this.y);
        System.out.println("Soldier size           : " + this.size);

        System.out.println("Weapon type            : " + this.weapon.getType());
        System.out.println("Weapon damage          : " + this.weapon.getDamage());
        System.out.println("Weapon fire of diapason: " + this.weapon.getDiapason());
        System.out.println("Bullet movement speed  : " + this.weapon.getSpeed());
        System.out.println("Weapon bullet count    : " + this.weapon.getBullet().getCount());
    }
    
}
