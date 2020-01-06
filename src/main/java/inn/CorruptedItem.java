package inn;

//Gestion des items corrompus
public class CorruptedItem {

    private Item item;
    private boolean corrupted;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isCorrupted() {
        return corrupted;
    }

    public void setCorrupted(boolean corrupted) {
        this.corrupted = corrupted;
    }

    public CorruptedItem (Item item, boolean corrupted){
        this.setItem(item);
        this.setCorrupted(corrupted);
    }
}
