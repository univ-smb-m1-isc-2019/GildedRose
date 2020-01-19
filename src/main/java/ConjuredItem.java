public class ConjuredItem extends MeilleurItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (quality > 0 && sellIn > 0) {
            quality = quality - 2;
        } else if (sellIn <= 0) quality = quality - 4;
        else if (quality <= 0) quality = 0;

        sellIn--;
    }
}
