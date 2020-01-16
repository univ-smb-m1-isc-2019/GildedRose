public abstract class AbstractItem {

    protected Item item;

    public AbstractItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateSellIn();
        updateQuality();
    }

    public void updateSellIn() {
        item.sellIn--;
    }

    public abstract void updateQuality();

    public boolean hasReachSellInBoundary() {
        return item.sellIn < 0;
    }

    public boolean hasReachMinQuality() {
        return item.quality <= 0;
    }

    public boolean hasReachMaxQuality() {
        return item.quality >= 50;
    }
}
