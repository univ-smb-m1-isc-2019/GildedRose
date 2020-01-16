public class Products extends Item {
    private static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;
    private static final int SELL_PASSED = 0;

    public Products(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return "Item : " + this.name + "| Sell-in : " + this.sellIn + "| Quality : " + this.quality;
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }

    private void increaseQuality(int rate) {
        quality = quality + (1 * rate);
    }

    void decreaseQuality(int rate) {
        quality = quality - (1 * rate);
    }

    private void setQualityToZero() {
        quality = 0;
    }

    void updateBackstagePass() {
        if (quality < MAX_QUALITY) {
            increaseQuality(1);

            if ((sellIn <= 10) && (quality < MAX_QUALITY)) {
                if ((quality < MAX_QUALITY - 1))
                    increaseQuality(2);
                else
                    increaseQuality(1);
            }

            if ((sellIn <= 5) && (quality < MAX_QUALITY)) {
                if (quality < MAX_QUALITY - 2)
                    increaseQuality(3);
                else if (quality < MAX_QUALITY - 1)
                    increaseQuality(2);
                else
                    increaseQuality(1);
            }
        }

        decreaseSellIn();

        if (sellIn < SELL_PASSED) {
            setQualityToZero();
        }
    }

    void updateAgedBrie() {
        decreaseSellIn();

        if (quality < MAX_QUALITY) {
            increaseQuality(1);
        }

        if (sellIn < SELL_PASSED && quality < MAX_QUALITY) {
            increaseQuality(1);
        }
    }

    void update() {
        decreaseSellIn();

        if (quality > MIN_QUALITY) {
            decreaseQuality(1);
        }

        if (sellIn < SELL_PASSED && quality > MIN_QUALITY) {
            decreaseQuality(2);
        }
    }
}
