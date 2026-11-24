package results;

public final class AssessmentComponent {
    private final String title;
    private final double value;

    public AssessmentComponent(String title, double value) {
        if (title == null) {
            throw new IllegalArgumentException("title cannot be null");
        }
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public double getValue() {
        return value;
    }
}
