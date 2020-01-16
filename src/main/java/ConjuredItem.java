public class ConjuredItem extends MyItem {


    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        super.updateQuality();
    }

    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }

    private void decrementItemSellIn() {
        setSellIn(getSellIn()-1);
    }
}
