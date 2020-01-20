public class BackstagePasses extends MeilleurItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50 && item.sellIn > 10) item.quality++;
        else if (item.quality < 49 && item.sellIn > 5) item.quality = item.quality + 2;
        else if (item.quality < 48 && item.sellIn > 0) item.quality = item.quality + 3;
        else item.quality = 0;
        if (item.sellIn >= 0) item.sellIn--;
    }
}
