package results;

import assessments.AssessmentFeed;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public final class AssessmentResultsWindow {
    private final List<Student> students;

    public AssessmentResultsWindow(List<Student> students) {
        this.students = students;
    }

    public void show() {
        String[] columns = {
                "Student name",
                "CID",
                "Type",
                AssessmentFeed.PROGRAMMING_TEST,
                AssessmentFeed.AI_PROJECT,
                AssessmentFeed.DESIGN_VIVA,
                "Overall weighted module mark"
        };

        Object[][] rows = new Object[students.size()][columns.length];
        for (int row = 0; row < students.size(); row++) {
            Student student = students.get(row);
            rows[row][0] = student.getName();
            rows[row][1] = student.getCid();
            rows[row][2] = student.getType();
            rows[row][3] = assessmentMark(student, AssessmentFeed.PROGRAMMING_TEST);
            rows[row][4] = assessmentMark(student, AssessmentFeed.AI_PROJECT);
            rows[row][5] = assessmentMark(student, AssessmentFeed.DESIGN_VIVA);
            rows[row][6] = format(student.getOverallWeightedMark());
        }

        DefaultTableModel model = new DefaultTableModel(rows, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                Student student = students.get(convertRowIndexToModel(row));
                if (student.meetsAiDiscrepancyCondition()) {
                    component.setBackground(Color.RED);
                    component.setForeground(Color.BLACK);
                }
                return component;
            }
        };
        table.setFillsViewportHeight(true);
        table.setRowHeight(42);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(130);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(55);
        for (int column = 3; column < columns.length; column++) {
            table.getColumnModel().getColumn(column).setPreferredWidth(210);
        }
        table.getTableHeader().setPreferredSize(new Dimension(0, 56));
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            {
                setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
                setToolTipText(value == null ? null : value.toString());
                return component;
            }
        });

        JFrame frame = new JFrame("Assessment Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.setSize(1100, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String assessmentMark(Student student, String title) {
        for (Assessment assessment : student.getAssessments()) {
            if (assessment.getTitle().equals(title)) {
                return format(assessment.getFinalMark());
            }
        }
        return "N/A";
    }

    private static String format(double value) {
        return String.format(Locale.ROOT, "%.2f", value);
    }
}
