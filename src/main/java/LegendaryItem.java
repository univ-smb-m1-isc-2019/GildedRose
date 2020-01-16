

public class LegendaryItem extends Item{


    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality()
    {
        /*Les items legendaires ne se degradent pas*/
    }
    public void updateSellIn()
    {
        /*Les items legendaires ne peuvent pas etre*/
    }
}
