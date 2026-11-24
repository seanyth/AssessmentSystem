package results;

import assessments.AssessmentFeed;
import java.util.ArrayList;
import java.util.List;

public final class StudentOperator {
    private StudentOperator() {
    }

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        for (String cid : AssessmentFeed.getCIDs()) {
            students.add(loadStudent(cid));
        }
        return students;
    }

    public Student loadStudent(String cid) {
        String name = AssessmentFeed.getStudentName(cid);
        String type = AssessmentFeed.getStudentType(cid);
        List<Assessment> assessments = new ArrayList<>();
        Exam.add(new Exam_Independent(cid));
        Exam.add(new Exam_AI(cid));

        if ("UG".equals(type)) {
            return new Student_UG(name, cid, assessments);
        }
        if ("MSc".equals(type)) {
            assessments.add(new Exam_Viva(cid));
            return new Student_MSc(name, cid, assessments);
        }
        throw new IllegalArgumentException("unknown student type: " + type);
    }
}
