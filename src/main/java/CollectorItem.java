public class CollectorItem extends ItemHolder {
    public CollectorItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public int getQualityAmountToChange() {
        return 1;
    }

    @Override
    public void updateQuality() {
        this.changeQualityOf(this.getQualityAmountToChange());
        if (this.getQuality() < 0)
            this.setQuality(0);
        this.sellInPassed();
    }
}
