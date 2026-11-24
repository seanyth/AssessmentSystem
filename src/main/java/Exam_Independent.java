package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Exam_Independent extends Exam {
    private final double programMark;
    private final boolean explainedSuccessfully;

    public Exam_Independent(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST,
                        AssessmentFeed.PROGRAM_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST,
                        AssessmentFeed.EXPLAINED_SUCCESSFULLY));
    }

    private Exam_Independent(String cid, double programMark,
                             double explanationResult) {
        super(AssessmentFeed.PROGRAMMING_TEST, 100.0, false,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.PROGRAM_MARK, programMark),
                        new AssessmentComponent(AssessmentFeed.EXPLAINED_SUCCESSFULLY,
                                explanationResult)),
                0.30, 0.25);
        this.programMark = programMark;
        this.explainedSuccessfully = explanationResult == 1.0;
    }

    public boolean isExplainedSuccessfully() {
        return explainedSuccessfully;
    }

    @Override
    public double getFinalMark() {
        return explainedSuccessfully ? programMark : Math.min(programMark, 40.0);
    }
}
