public class Shopping {
    private int[] items;

//    No args constructor
    public Shopping() {
        items = new int[5];
    }

//    method add item
    public void addItem(int x, int y){
        items[x] = y;
    }

//    getters
   public int[] getItems() {
        return items;
    }
}
