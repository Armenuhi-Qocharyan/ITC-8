public class PolytechnicFactory implements UniversityFactory {
    @Override
    public Programmer getProgrammer() {
        return new PolytechnicProgrammer();
    }

    @Override
    public Physicist getPhysicist() {
        return new PolytechnicPhysicist();
    }
}
