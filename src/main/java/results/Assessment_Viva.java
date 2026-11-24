package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Assessment_Viva extends Assessment {
    private final double desi;
    private final double expl;

    public Assessment_Viva(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA,
                        AssessmentFeed.DESIGN_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.DESIGN_VIVA,
                        AssessmentFeed.EXPLANATION_MARK));
    }

    private Assessment_Viva(String cid, double desi, double expl) {
        super(AssessmentFeed.DESIGN_VIVA, 100.0, false,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.DESIGN_MARK, desi),
                        new AssessmentComponent(AssessmentFeed.EXPLANATION_MARK,
                                expl)),
                -1.0, 0.30);
        this.desi = desi;
        this.expl = expl;
    }

    @Override
    public double getFinalMark() {
        return 0.5 * desi + 0.5 * expl;
    }
}
