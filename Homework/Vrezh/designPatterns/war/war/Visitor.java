package war;

public interface Visitor {
    void visit(Soldier soldier);
    void visit(Tank soldier);
    void visit(Bullet bullet);
}
