public class BackstagePasses extends improveItem {
    int maximalValue;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        setMaximalValue(50);
    }

    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }
    private void decrementItemSellIn() {
        setSellIn(getSellIn()-1);
    }

    @Override
    protected void updateQuality() {
        if (getQuality() < getMaximalValue()) {
            incrementItemQuality();
        }
    }

    public void incrementItemQuality()
    {
        setQuality(getQuality() + 1);
    }
    public  int getMaximalValue(){ return maximalValue; }

    public void setMaximalValue(int value)
    {
        this.maximalValue = value;
    }

}
