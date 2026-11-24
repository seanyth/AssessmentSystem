package results;

import java.util.List;
import java.util.Locale;

public final class AssessmentTechnicalReport {
    private AssessmentTechnicalReport() {
    }

    public static void print(List<Student> students) {
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("CID: " + student.getCid());
            System.out.println("Type: " + student.getType());

            for (Assessment assessment : student.getAssessments()) {
                System.out.println(assessment.getTitle() + " — final mark: "
                        + format(assessment.getFinalMark()));
                for (AssessmentComponent component : assessment.getComponents()) {
                    System.out.println("  " + component.getTitle() + ": "
                            + format(component.getValue()));
                }
            }

            System.out.println("Overall weighted module mark: "
                    + format(student.getOverallWeightedMark()));
            System.out.println("AI-permitted average: "
                    + format(student.getAverageForAiPermission(true)));
            System.out.println("Non-AI average: "
                    + format(student.getAverageForAiPermission(false)));
            System.out.println("AI discrepancy condition met: "
                    + student.meetsAiDiscrepancyCondition());
            System.out.println();
        }
    }

    private static String format(double value) {
        return String.format(Locale.ROOT, "%.2f", value);
    }
}
