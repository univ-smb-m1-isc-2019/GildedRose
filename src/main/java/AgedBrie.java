public class AgedBrie extends improveItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }
}
