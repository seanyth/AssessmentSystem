package results;

import java.util.List;

public final class Student_MSc extends Student {
    public Student_MSc(String name, String cid, List<Exam> exams) {
        super(name, cid, "MSc", exams);
    }

    @Override
    double weightFor(Exam exam) {
        if (exam.getMsc_Weight() < 0.0) {
            throw new IllegalArgumentException("Assessment can't be negative");
        }
        return exam.getMsc_Weight();
    }
}

