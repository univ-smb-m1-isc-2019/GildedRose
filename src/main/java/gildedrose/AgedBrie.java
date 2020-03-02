package gildedrose;

public class AgedBrie extends ItemWrapper {

    public AgedBrie(Item item) {
        super(item);
    }


    protected void checkQuality() {
        if (item.getQuality() < 50) {
            incrementQuality(item);
        }
    }

    protected void checkExpiration() {
        if (item.getSellIn() < 0) {
            if (item.getQuality() < 50) {
                incrementQuality(item);
            }
        }
    }


}
