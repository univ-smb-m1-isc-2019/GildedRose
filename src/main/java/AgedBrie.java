public class AgedBrie extends improveItem {


    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        setMinimalValue(0);
        setMaximalValue(50);
    }


    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }

    @Override
    protected void updateQuality() {
        if (getQuality() < getMaximalValue())
        {
            incrementItemQuality();
        }
    }





}
