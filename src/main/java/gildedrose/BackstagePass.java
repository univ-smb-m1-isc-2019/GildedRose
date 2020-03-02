package gildedrose;

public class BackstagePass extends ItemWrapper {

    public BackstagePass(Item item) {
        super(item);
    }

    protected void checkQuality() {
        if (item.getQuality() < 50) {

            incrementQuality(item);

            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    incrementQuality(item);
                }
            }

            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    incrementQuality(item);
                }
            }
        }
    }

    protected void checkExpiration() {
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }
}