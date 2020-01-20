public class AgedBrie extends MeilleurItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (this.item.quality < 50) item.quality++;

        if (item.sellIn >= 0) item.sellIn--;
    }
}
