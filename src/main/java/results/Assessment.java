package results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Assessment {
    private String title;
    private double max_mark;
    private boolean ai;
    private List<AssessmentComponent> components;
    private double ug_weight;
    private double msc_weight;

    protected Assessment(String title, double max_mark, boolean ai,
                         List<AssessmentComponent> components,
                         double ug_weight, double msc_weight) {
        if (title == null || components == null) {
            throw new IllegalArgumentException("inputs cannot be null");
        }
        this.title = title;
        this.max_mark = max_mark;
        this.ai = ai;
        this.components = Collections.unmodifiableList(new ArrayList<>(components));
        this.ug_weight = ug_weight;
        this.msc_weight = msc_weight;
    }

    public String getTitle() {
        return title;
    }

    public double getMax_mark() {
        return max_mark;
    }

    public boolean isAi() {
        return ai;
    }

    public List<AssessmentComponent> getComponents() {
        return components;
    }

    public double getUg_weight() {
        return ug_weight;
    }

    public double getMsc_weight() {
        return msc_weight;
    }

    public abstract double getFinalMark();
}
