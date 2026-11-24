package results;

import java.util.List;

public final class UgStudent extends Student {
    public UgStudent(String name, String cid, List<Assessment> assessments) {
        super(name, cid, "UG", assessments);
    }

    @Override
    protected double weightFor(Assessment assessment) {
        if (assessment.getUg_weight() < 0.0) {
            throw new IllegalArgumentException("missing assessment weight");
        }
        return assessment.getUg_weight();
    }
}
