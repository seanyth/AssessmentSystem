package results;

import java.util.List;

public final class Student_UG extends Student {
    public Student_UG(String name, String cid, List<Exam> exams) {
        super(name, cid, "UG", exams);
    }

    @Override
    double weightFor(Exam exam) {
        if (exam.getUg_weight() < 0.0) {
            throw new IllegalArgumentException("Assessment is not taken by UG students");
        }
        return exam.getUg_weight();
    }
}
