public class Weapon {
    private int magazin;
    private int damage;
    private String name;
    private double x;
    private double y; 

    public Weapon(int magazin,int damage, String name){
        this.magazin = magazin;
        this.damage = damage;
        this.name = name;
    }

    public void changeCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int Shoot(int v,double angle,Soldier second,double distance) {
        for(int i = 0; i < this.magazin; ++i) {
        Cartridge one = new Cartridge(this.x, this.y);
        one.changeDamage(this.damage);
            if(one.Move(v, angle, second.getX(), second.getY(), distance)) {
                second.changeHealth(one.getDamage());
            } else {
                System.out.println("Did not hit the mark !!!");
            }
        }
        return this.damage;
    }

    public void Info() {
        System.out.println("Weapon name:  " + this.name + "| damage: " + this.damage + " | magazin: " + this.magazin + " |");
    }

}