package vn.edu.iuh.fit.Enums;

public enum SkillType {
    BEGINNER(0),
    INTERMEDIATE(1),
    MASTER(2);

    private final int value;

    SkillType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SkillType getSkillType(int value) {
        return value == 2 ? MASTER : value == 1 ? INTERMEDIATE : BEGINNER;
    }
}
