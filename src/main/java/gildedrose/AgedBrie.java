package gildedrose;

public class AgedBrie extends GenericItem {

    public AgedBrie(Item item) {
        super(item);
    }


    protected void updateQuality() {
        if (item.getQuality() < 50) {
            incrementQuality(item);
        }
    }

    protected void checkExpiration() {
        if (item.getSellIn() < 0 && item.getQuality() < 50) {
            incrementQuality(item);
        }
    }


}
