package results;

import java.util.List;
import javax.swing.SwingUtilities;

public final class AssessmentApplication {
    private AssessmentApplication() {
    }

    public static void main(String[] args) {
        List<Student> students = StudentOperator.loadStudents();
        AssessmentTechnicalReport.print(students);
        SwingUtilities.invokeLater(() -> new AssessmentResultsWindow(students).show());
    }
}
