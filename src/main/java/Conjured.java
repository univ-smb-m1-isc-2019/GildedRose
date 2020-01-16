public class Conjured extends Products {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    public void update(){
        super.decreaseSellIn();

        if (quality > super.MIN_QUALITY) {
            super.decreaseQuality(2);
        }
    }
}
