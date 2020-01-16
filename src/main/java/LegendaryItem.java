

public class LegendaryItem extends Item{


    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality()
    {
        /*Les items legendaires ne se degrades pas*/
    }
}
