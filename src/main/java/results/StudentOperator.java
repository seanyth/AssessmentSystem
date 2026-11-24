package results;

import assessments.AssessmentFeed;
import java.util.ArrayList;
import java.util.List;

public final class StudentOperator {
    private StudentOperator() {
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        for (String cid : AssessmentFeed.getCIDs()) {
            students.add(loadStudent(cid));
        }
        return students;
    }

    public static Student loadStudent(String cid) {
        String name = AssessmentFeed.getStudentName(cid);
        String type = AssessmentFeed.getStudentType(cid);
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment_Indi(cid));
        assessments.add(new Assessment_AI(cid));

        if ("UG".equals(type)) {
            return new UgStudent(name, cid, assessments);
        }
        if ("MSc".equals(type)) {
            assessments.add(new Assessment_Viva(cid));
            return new MscStudent(name, cid, assessments);
        }
        throw new IllegalArgumentException("Unknown student type: " + type);
    }
}
