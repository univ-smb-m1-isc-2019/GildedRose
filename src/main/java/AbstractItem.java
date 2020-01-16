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

    public boolean hasReachQualityBoundary() {
        return item.quality <= 0 || item.quality > 50;
    }
}
