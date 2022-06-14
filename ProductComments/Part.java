
public class Part {

    private final int partId;
    private final int parentPartId;

    public Part(int partId, int parentId) {
        this.partId = partId;
        this.parentPartId = parentId;
    }

    public int getPartId() {
        return partId;
    }

    public int getParentPartId() {
        return parentPartId;
    }
}
