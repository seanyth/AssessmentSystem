package results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Exam {
    private String title;
    private int max_mark;

    private boolean ai;
    private int ug_weight;
    private int msc_Weight;

    private List<ExamContent> contents;

    public Exam(String title, int max_mark, boolean ai, List<ExamContent> contents,int ug_weight, int msc_Weight) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        this.title = title;
        this.max_mark = max_mark;
        this.ai = ai;
        this.ug_weight = ug_weight;
        this.msc_Weight = msc_Weight;

        this.contents = Collections.unmodifiableList(new ArrayList<>(contents));
    }

    public String getTitle() {
        return title;
    }
    public int getMax_mark() {
        return max_mark;
    }
    public boolean isAi() {
        return ai;
    }
    public int getUg_weight() {
        return ug_weight;
    }
    public int getMsc_Weight() {
        return msc_Weight;
    }


}
