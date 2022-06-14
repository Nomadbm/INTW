public class Comment {
    private final int partId;
    private final String comment;

    public Comment(int partId, String comment) {
        this.partId = partId;
        this.comment = comment;
    }

    public int getPartId() {
        return partId;
    }

    public String getComment() {
        return comment;
    }

}
