package gildedrose;

public class BackstagePass extends GenericItem {

    public BackstagePass(Item item) {
        super(item);
    }

    protected void updateQuality() {
        if (beforeConcert()) {

            incrementQuality(item);

            if (item.getSellIn() < 11 && beforeConcert()) {
                incrementQuality(item);
            }

            if (item.getSellIn() < 6 && beforeConcert()) {
                incrementQuality(item);
            }
        }
    }

    private boolean beforeConcert() {
        return item.getQuality() < 50;
    }

    protected void checkExpiration() {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }
}