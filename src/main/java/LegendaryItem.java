public class LegendaryItem extends ItemHolder {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public void sellInPassed() {

    }

    @Override
    public int getQualityAmountToChange() {
        return 0;
    }

    @Override
    public void updateQuality() {
        
    }
}
