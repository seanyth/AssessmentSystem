package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Exam_AI extends Exam {
    private final double functionalityMark;
    private final double verificationMark;

    public Exam_AI(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.FUNCTIONALITY_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.VERIFICATION_MARK));
    }

    private Exam_AI(String cid, double functionalityMark,
                    double verificationMark) {
        super(AssessmentFeed.AI_PROJECT, 100.0, true,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.FUNCTIONALITY_MARK,
                                functionalityMark),
                        new AssessmentComponent(AssessmentFeed.VERIFICATION_MARK,
                                verificationMark)),
                0.70, 0.45);
        this.functionalityMark = functionalityMark;
        this.verificationMark = verificationMark;
    }

    @Override
    public double getFinalMark() {
        return 0.4 * functionalityMark + 0.6 * verificationMark;
    }
}
