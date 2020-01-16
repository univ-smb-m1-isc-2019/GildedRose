

public class LegendaryItem extends MyItem{


    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void updateQuality()
    {
        /*Les items legendaires ne se degradent pas*/
    }

    @Override
    protected void udpdateSellIn()
    {
        /*Les items legendaires ne peuvent pas etre*/
    }
}
