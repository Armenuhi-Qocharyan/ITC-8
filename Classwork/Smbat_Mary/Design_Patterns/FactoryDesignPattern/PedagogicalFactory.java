public class PedagogicalFactory implements UniversityFactory {
    @Override
    public Programmer getProgrammer() {
        return new PedagogicalProgrammer();
    }

    @Override
    public Physicist getPhysicist() {
        return new PedagogicalPhysicist();
    }
}
