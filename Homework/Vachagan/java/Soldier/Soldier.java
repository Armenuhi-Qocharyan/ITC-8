public class Soldier {

    private double x;
    private double y;
    private String name;
    private String nation;
    private int health = 100;
    private Weapon weapon;

    public Soldier(double x,double y,String name,String nation,Weapon weapon) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.nation = nation;
        this.weapon = weapon;
        this.weapon.changeCoordinate(x,y);
    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public void changeHealth(int health) {
        if(this.health <= 0) {
            return;
        }
        this.health = this.health - health;
        Dead(this.health);
    }

    private boolean Dead(int health) {
        if(health <= 0){
            System.out.println("Soldier " + this.name + " from " + this.nation + " killed.");
            return true;
        }
        System.out.println("Soldier " + this.name + " from " + this.nation + " injured. | Health -> " + this.health); 
        return false;
    }

    public void Info() {
        System.out.println("Coordinate: x = " + this.x + " y = " + this.y + " | Soldier name: "+this.name +" | Nation: " + this.nation + " |  Health: " + this.health);        
        weapon.Info();
    }

    public void Shoot(int v,double angle,Soldier other,double distance) {
        this.weapon.Shoot(v,angle,other,distance);
    }
    
}