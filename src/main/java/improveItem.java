


public abstract class improveItem extends MyItem {


    public improveItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void updateQuality()
    {

    }
    protected void udpdateSellIn()
    {

    }

    protected void incrementItemQuality()
    {
        setQuality(getQuality() + 1);
    }



}
