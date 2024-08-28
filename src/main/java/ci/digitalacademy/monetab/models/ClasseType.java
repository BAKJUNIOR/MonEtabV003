package ci.digitalacademy.monetab.models;

public enum ClasseType {
    Terminale("Tle"),
    PREMIERE("1ère"),
    SECONDE("2nde"),
    TROISIEME("3ème"),
    QUATRIEME("4ème"),
    CINQUIEME("5ème"),
    SIXIEME("6ème");

    private final String ClasseName;

    ClasseType(String classeName) {
        this.ClasseName = classeName;
    }

    public String getClasseName() {
        return ClasseName;
    }
}
