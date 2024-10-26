package vn.edu.iuh.fit.enums;

public enum SkillType {
    BEGINNER(0),
    INTERMEDIATE(1),
    MASTER(2);

    private final int typeNum;

    SkillType(int typeNum) {
        this.typeNum = typeNum;
    }

    public int getTypeNum() {
        return this.typeNum;
    }

    public static SkillType getSkillType(int typeNum) {
        return switch (typeNum) {
            case 0 -> SkillType.BEGINNER;
            case 1 -> SkillType.INTERMEDIATE;
            case 2 -> SkillType.MASTER;
            default -> throw new IllegalArgumentException("Invalid skill type number: " + typeNum);
        };
    }

}
