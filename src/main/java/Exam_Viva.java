package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Exam_Viva extends Exam {
    private final double designMark;
    private final double explanationMark;

    public Exam_Viva(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA,
                        AssessmentFeed.DESIGN_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA,
                        AssessmentFeed.EXPLANATION_MARK));
    }

    private Exam_Viva(String cid, double designMark, double explanationMark) {
        super(AssessmentFeed.DESIGN_VIVA, 100.0, false,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.DESIGN_MARK, designMark),
                        new AssessmentComponent(AssessmentFeed.EXPLANATION_MARK,
                                explanationMark)),
                -1.0, 0.30);
        this.designMark = designMark;
        this.explanationMark = explanationMark;
    }

    @Override
    public double getFinalMark() {
        return 0.5 * designMark + 0.5 * explanationMark;
    }
}
