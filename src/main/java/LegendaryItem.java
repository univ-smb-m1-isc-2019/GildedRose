public class LegendaryItem extends Item{


    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        //Nothing to do. A legendary Item does not have quality changes
    }
}
