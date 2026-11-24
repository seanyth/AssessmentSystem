package results;

import java.util.List;

public final class MscStudent extends Student {
    public MscStudent(String name, String cid, List<Assessment> assessments) {
        super(name, cid, "MSc", assessments);
    }

    @Override
    protected double weightFor(Assessment assessment) {
        if (assessment.getMsc_weight() < 0.0) {
            throw new IllegalArgumentException("miss assessment weight");
        }
        return assessment.getMsc_weight();
    }
}
