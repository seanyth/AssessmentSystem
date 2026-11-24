package results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Student {
    private final String name;
    private final String cid;
    private final String type;
    private final List<Assessment> assessments;

    protected Student1(String name, String cid, String type, List<Assessment> assessments) {
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

}
