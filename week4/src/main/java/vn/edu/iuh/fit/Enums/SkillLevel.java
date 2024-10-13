package vn.edu.iuh.fit.Enums;

public enum SkillLevel {
    JUNIOR(0),
    MIDDLE(1),
    SENIOR(2);

    private final int value;

    SkillLevel(int value){
        this.value = value;
    }

    public int getLevel(){
        return this.value;
    }

    public static SkillLevel getSkillLevel(int value){
        return value == 0 ? JUNIOR : value == 1 ? MIDDLE: SENIOR;
    }
}
