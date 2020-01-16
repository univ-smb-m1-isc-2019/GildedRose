public class BackstagePasses extends improveItem {
    private int maximalValue;
    private int increaseByTwo;
    private int increaseByThree;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        setMaximalValue(50);
        setIncreaseByTwo(11);
        setIncreaseByThree(6);

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
    
    public void setIncreaseByTwo(int value)
    {
        increaseByTwo = value;
    }
    public void setIncreaseByThree(int value)
    {
        increaseByThree = value;
    }

    public int getIncreaseByTwo()
    {
        return increaseByTwo;
    }
    public int getIncreaseByThree()
    {
        return increaseByThree;
    }

}
