public class CommonItem extends Item {
    private int minimalValue;

    public CommonItem(String name, int sellIn, int quality)
    {

        super(name, sellIn, quality);
        setMinimalValue(0);
    }

    public void updateQuality()
    {
        if (getQuality() > getMinimalValue()) {
            decrementItemQuality();
        }

        if (getSellIn() < getMinimalValue() && getQuality() > getMinimalValue())
        {
            decrementItemQuality();
        }

    }
    public void updateSellIn()
    {
        decrementItemSellIn();

    }

    private void decrementItemSellIn() {
        setSellIn(getSellIn()-1);
    }


    private void decrementItemQuality() {
        setQuality(getQuality() - 1);
    }


    public void setMinimalValue(int min)
    {
        this.minimalValue = min;
    }

    public int getMinimalValue()
    {
        return minimalValue;
    }



}
