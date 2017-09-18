public interface UniversityFactory {
    public static PolytechnicFactory polytechnic = new PolytechnicFactory();
    public static PedagogicalFactory pedagogical = new PedagogicalFactory();
    public static UniversityFactory getUniversity(String university) {
        if (university.equals("Polytechnic")) {
            return polytechnic;
        } else if (university.equals("Pedagogical")) {
            return pedagogical;
        }
        return null;
    }

    public Programmer getProgrammer();
    public Physicist getPhysicist();
}
