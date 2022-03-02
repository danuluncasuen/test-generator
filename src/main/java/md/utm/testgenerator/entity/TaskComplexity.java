package md.utm.testgenerator.entity;

public enum TaskComplexity {

    LOW(1),
    MEDIUM(2),
    HIGH(3),
    EXTREME(4);

    public final int label;

    TaskComplexity(int label) {
        this.label = label;
    }

    public static TaskComplexity getByLabel(int label) {
        for (TaskComplexity tc : values()) {
            if (tc.label == label) {
                return tc;
            }
        }
        return null;
    }
}
