public abstract class Student {
    private String name;
    private String cid;
    private String type;

    public Student(String name, String cid, String type) {
        if (name == null || cid == null || type == null || assessments == null) {
            throw new IllegalArgumentException("one or more student info is null");
        }
        this.name = name;
        this.cid = cid;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getCid() {
        return cid;
    }

    public String getType() {
        return type;
    }
}
