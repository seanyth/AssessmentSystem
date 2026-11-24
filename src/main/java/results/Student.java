package results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Student {
    private final String name;
    private final String cid;
    private final String type;
    private final List<Assessment> assessments;

    protected Student(String name, String cid, String type, List<Assessment> assessments) {
        if (name == null || cid == null || type == null || assessments == null) {
            throw new IllegalArgumentException("input must not be null");
        }
        this.name = name;
        this.cid = cid;
        this.type = type;
        this.assessments = Collections.unmodifiableList(new ArrayList<>(assessments));
    }

    public String getName() {
        return name;
    }

    public String getCid() {
        return cid;
    }

    public String getType() {
        return type;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    protected abstract double weightFor(Assessment assessment);

    public double getOverallWeightedMark() {
        double weightedTotal = 0.0;
        double totalWeight = 0.0;
        for (Assessment assessment : assessments) {
            double weight = weightFor(assessment);
            weightedTotal += assessment.getFinalMark() * weight;
            totalWeight += weight;
        }
        if (totalWeight == 0.0) {
            throw new IllegalStateException("assessments weight is 0");
        }
        return weightedTotal / totalWeight;
    }

    public double getAverageForAiPermission(boolean isAi) {
        double total = 0.0;
        int count = 0;
        for (Assessment assessment : assessments) {
            if (assessment.isAi() == isAi) {
                total += assessment.getFinalMark();
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalStateException("assessments found for requested category");
        }
        return total / count;
    }

    public boolean meetsAiDiscrepancyCondition() {
        return getAverageForAiPermission(true) - getAverageForAiPermission(false) >= 20.0;
    }
}

