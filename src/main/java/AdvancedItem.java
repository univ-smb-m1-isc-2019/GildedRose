public class AdvancedItem {
    public Item item;
    public boolean conjured;

    public AdvancedItem(Item item, boolean conjured) {
        this.setItem(item);
        this.setConjured(conjured);
    }

    public Item getItem() { return item; }

    public void setItem(Item item) {this.item = item; }

    public boolean getConjured() {return conjured;}

    public void setConjured(boolean conjuct) {this.conjured = conjuct; }
}

