package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Assessment_AI extends Assessment {
    private final double func;
    private final double veri;

    public Assessment_AI(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.FUNCTIONALITY_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.AI_PROJECT,
                        AssessmentFeed.VERIFICATION_MARK));
    }

    private Assessment_AI(String cid, double func,
                          double veri) {
        super(AssessmentFeed.AI_PROJECT, 100.0, true,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.FUNCTIONALITY_MARK,
                                func),
                        new AssessmentComponent(AssessmentFeed.VERIFICATION_MARK,
                                veri)),
                0.70, 0.45);
        this.func = func;
        this.veri = veri;
    }

    @Override
    public double getFinalMark() {
        return 0.4 * func + 0.6 * veri;
    }
}
