package vn.edu.iuh.fit.enums;

public enum SkillLevel {
    JUNIOR(0),
    MIDDLE(1),
    SENIOR(2);
    private final int level;

    private SkillLevel(int level) {
        this.level = level;
    }

    public int getLevelNumber() {
        return this.level;
    }

    public static SkillLevel getSkillLevel(int level) {
        return switch (level) {
            case 0 -> SkillLevel.JUNIOR;
            case 1 -> SkillLevel.MIDDLE;
            case 2 -> SkillLevel.SENIOR;
            default -> throw new IllegalArgumentException("Invalid skill level: " + level);
        };
    }

}
