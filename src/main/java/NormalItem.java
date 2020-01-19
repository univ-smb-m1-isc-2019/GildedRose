public class NormalItem extends ItemHolder {
    public NormalItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public int getQualityAmountToChange() {
        int normalAmount = -1;
        if (this.getSellIn() >= 0)
            return normalAmount;
        else
            return normalAmount * 2;
    }

    @Override
    public void updateQuality() {
        this.changeQualityOf(this.getQualityAmountToChange());
        if (this.getQuality() < 0)
            this.setQuality(0);
        this.sellInPassed();
    }
}
