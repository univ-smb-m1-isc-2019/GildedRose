public class BackstagePasses extends MeilleurItem {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellIn > 10) quality++;
        else if (sellIn > 5) quality = quality + 2;
        else if (sellIn > 0) quality = quality + 3;
        else quality = 0;
        sellIn--;
    }
}
