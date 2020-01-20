public class NormalItem extends MeilleurItem {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0 && item.sellIn > 0)
            item.quality--;
        else if (item.quality > 1) item.quality = item.quality - 2;
        else item.quality = 0;

        if (item.sellIn >= 0) item.sellIn--;
    }
}
