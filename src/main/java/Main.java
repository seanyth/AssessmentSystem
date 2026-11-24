package results;

import java.util.List;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        List<Student> students = StudentOperator.loadStudents();
        for (Student student : students) {
            System.out.printf(student.getName());
        }
    }
}