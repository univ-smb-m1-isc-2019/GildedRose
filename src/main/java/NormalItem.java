public class NormalItem extends ItemHolder {
    public NormalItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public int getQualityToRemove() {
        return 1;
    }

    @Override
    public void updateQuality() {
        this.changeQualityOf(this.getQualityToRemove());
        if (this.getQuality() < 0)
            this.setQuality(0);
        this.sellInPassed();
    }
}
