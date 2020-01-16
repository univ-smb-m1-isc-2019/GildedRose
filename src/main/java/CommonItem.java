public class CommonItem extends MyItem {


    public CommonItem(String name, int sellIn, int quality)
    {

        super(name, sellIn, quality);
        setMinimalValue(0);
    }

    @Override
    protected void updateQuality() {
        if (getQuality() > getMinimalValue()) {
            decrementItemQuality();
        }

        if (getSellIn() < getMinimalValue() && getQuality() > getMinimalValue())
        {
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
