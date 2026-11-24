package results;

import java.util.List;

public abstract class Student {
    private String name;
    private String cid;
    private String type;
    private List<Exam> exams;

    public Student(String name, String cid, String type, List<Exam> exams) {
        if (name == null || cid == null || type == null || exams == null) {
            throw new IllegalArgumentException("one or more student info is null");
        }
        this.name = name;
        this.cid = cid;
        this.type = type;
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

    public List<Assessment> getExams() {
        return exams;
    }

    public abstract double weightFor(Exam exam);

}
