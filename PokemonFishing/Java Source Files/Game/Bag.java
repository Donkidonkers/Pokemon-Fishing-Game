import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> inv;
    
    public Bag() {
        inv = new ArrayList<>();
    }

    public boolean add(Item i) {
        return inv.add(i);
    }
    public ArrayList<Item> getBag() {
        return inv;
    }
}
