package gildedrose;

public class ItemWrapper {

    protected final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
    }

    public int getQuality() {
        return item.getQuality();
    }

    public void setQuality(int quality) {
        item.setQuality(quality);
    }

    protected void decrementSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    protected void incrementQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }


    public void checks() {

        updateQuality();

        updateSellIn();

        checkExpiration();

    }

    protected void updateQuality() {
        decrementQuality();
    }

    protected void checkExpiration() {
        if (item.getSellIn() < 0) {
            decrementQuality();
        }
    }

    protected void decrementQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    protected void updateSellIn() {
        decrementSellIn(item);
    }

}
