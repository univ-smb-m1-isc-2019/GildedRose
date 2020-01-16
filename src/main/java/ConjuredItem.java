public class ConjuredItem extends MyItem {


    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (getQuality() > getMinimalValue()) {
            decrementItemQuality();
            decrementItemQuality();
        }

        if (getSellIn() < getMinimalValue() && getQuality() > getMinimalValue())
        {
            decrementItemQuality();
            decrementItemQuality();
        }
    }

    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }

    private void decrementItemSellIn() {
        setSellIn(getSellIn()-1);
    }
    private void decrementItemQuality() {
        setQuality(getQuality() - 1);
    }
}
