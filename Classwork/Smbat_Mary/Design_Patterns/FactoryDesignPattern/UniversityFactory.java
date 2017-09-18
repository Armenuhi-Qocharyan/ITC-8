public interface UniversityFactory {
    public static UniversityFactory getUniversity(String university) {
        if (university.equals("Polytechnic")) {
            return new PolytechnicFactory();
        } else if (university.equals("Pedagogical")) {
            return new PedagogicalFactory();
        } else {
            return null;
        }
    }

    public Programmer getProgrammer();
    public Physicist getPhysicist();
}
