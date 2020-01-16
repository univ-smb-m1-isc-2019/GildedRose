public class CommonItem extends Item {
    private int minimalValue;

    public CommonItem(String name, int sellIn, int quality)
    {

        super(name, sellIn, quality);
        setMinimalValue(0);
    }

    public void updateQuality()
    {
        if (getItemQuality() > getMinimalValue()) {
            decrementItemQuality();
        }
    }

    private void decrementItemQuality() {
        setQuality(getItemQuality() -1);
    }

    public int getItemQuality()
    {
        return this.quality;
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
