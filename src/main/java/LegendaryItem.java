public class LegendaryItem extends ItemHolder {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public void sellInPassed() {

    }

    @Override
    public int getQualityToRemove() {
        return 0;
    }

    @Override
    public void updateQuality() {
        this.changeQualityOf(this.getQualityToRemove());
        if (this.getQuality() < 0)
            this.setQuality(0);
        this.sellInPassed();
    }
}
