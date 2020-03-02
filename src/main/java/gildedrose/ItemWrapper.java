package gildedrose;

public class ItemWrapper {

    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
    }

    public int getSellIn() {
        return item.getSellIn();
    }

    public void setSellIn(int sellIn) {
        item.setSellIn(sellIn);
    }

    public int getQuality() {
        return item.getQuality();
    }

    public void setQuality(int quality) {
        item.setQuality(quality);
    }
}
