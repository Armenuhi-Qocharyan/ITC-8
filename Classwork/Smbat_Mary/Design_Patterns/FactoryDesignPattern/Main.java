public class Main {
    public static void main(String[] args) {
        UniversityFactory university = UniversityFactory.getUniversity("Polytechnic");
        if (university == null) {
            return;
        }
        Programmer polytechnicProgrammer = university.getProgrammer();
        Physicist polytechnicPhysicist = university.getPhysicist();

        polytechnicProgrammer.draw();
        polytechnicPhysicist.draw();

        university = UniversityFactory.getUniversity("Pedagogical");
        if (university == null) {
            return;
        }
        Programmer pedagogicProgrammer = university.getProgrammer();
        Physicist pedagogicPhysicist = university.getPhysicist();

        pedagogicProgrammer.draw();
        pedagogicPhysicist.draw();
    }
}