public abstract class Exam {
    private String title;
    private int max_mark;
    private boolean ai;
    private int ug_weight;
    private int msc_Weight;

    public Exam(String title, int max_mark, boolean ai, int ug_weight, int msc_Weight) {
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        this.title = title;
        this.max_mark = max_mark;
        this.ai = ai;
        this.ug_weight = ug_weight;
        this.msc_Weight = msc_Weight;
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
