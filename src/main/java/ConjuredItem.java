public class ConjuredItem extends MeilleurItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 1 && item.sellIn > 0)
            item.quality = item.quality - 2;
        else if (item.quality > 3) item.quality = item.quality - 4;
        else item.quality = 0;

        if (item.sellIn >= 0) item.sellIn--;
    }
}
