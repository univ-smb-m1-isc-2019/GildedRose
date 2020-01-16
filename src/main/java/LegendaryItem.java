public class LegendaryItem extends SpecializedItem{
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        //Nothing to do. A legendary Item does not have quality changes
    }
}
