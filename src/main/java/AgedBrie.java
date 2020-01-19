public class AgedBrie extends MeilleurItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (this.quality < 50) quality++;

        sellIn--;
    }
}
