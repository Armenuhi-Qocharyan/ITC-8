public class Main {
    public static void main(String[] args) {
        showProfessions("Polytechnic");
        showProfessions("Pedagogical");
    }

    public static void showProfessions(String univer) {
        UniversityFactory university = UniversityFactory.getUniversity(univer);
        if (university == null) {
            return;
        }
        Programmer programmer = university.getProgrammer();
        Physicist physicist = university.getPhysicist();

        programmer.draw();
        physicist.draw();
    }
}
