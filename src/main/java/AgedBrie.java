public class AgedBrie extends ItemFactory{
    public AgedBrie( int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }
    @Override
    protected void  doUpdateQuality(){

        if (quality < 50) {
            quality++;
        }
        sellIn--;

        if (sellIn < 0) {
            if (quality < 50) {
                quality++;
            }
        }

    }
}
