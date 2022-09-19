public class Repository {
    private String itemName;
    private int groupCount;
    private double groupPrice;
    private int numAvailable;

//    Constructors

    public Repository(String itemName, int groupCount, double groupPrice, int numAvailable) {
        this.itemName = itemName;
        this.groupCount = groupCount;
        this.groupPrice = groupPrice;
        this.numAvailable = numAvailable;
    }
// No args constructor
    public Repository() {
    }

//    Getters and setters

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public double getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(double groupPrice) {
        this.groupPrice = groupPrice;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }
}
