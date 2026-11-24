package results;

import assessments.AssessmentFeed;
import java.util.Arrays;

public final class Assessment_Indi extends Assessment {
    private final double prog;
    private final boolean expl;

    public Assessment_Indi(String cid) {
        this(cid,
                AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST,
                        AssessmentFeed.PROGRAM_MARK),
                AssessmentFeed.getResult(cid, AssessmentFeed.PROGRAMMING_TEST,
                        AssessmentFeed.EXPLAINED_SUCCESSFULLY));
    }

    private Assessment_Indi(String cid, double prog,
                            double expl) {
        super(AssessmentFeed.PROGRAMMING_TEST, 100.0, false,
                Arrays.asList(
                        new AssessmentComponent(AssessmentFeed.PROGRAM_MARK, prog),
                        new AssessmentComponent(AssessmentFeed.EXPLAINED_SUCCESSFULLY,
                                expl)),
                0.30, 0.25);
        this.prog = prog;
        this.expl = expl == 1.0;
    }

    public boolean isExpl() {
        return expl;
    }

    @Override
    public double getFinalMark() {
        return expl ? prog : Math.min(prog, 40.0);
    }
}
