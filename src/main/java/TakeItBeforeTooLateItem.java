public class TakeItBeforeTooLateItem extends ItemHolder {
    public TakeItBeforeTooLateItem(String name, int sellIn, int quality) {
        super(new Item(name, sellIn, quality));
    }

    @Override
    public int getQualityAmountToChange() {
        int normalAmount;

        if (this.getSellIn() <= 3)
            normalAmount = 3;
        else if (this.getSellIn() <= 10)
            normalAmount = 2;
        else
            normalAmount = 1;

        if (this.getSellIn() >= 0)
            return normalAmount;
        else
            return - this.getQuality();
    }

    @Override
    public void updateQuality() {
        this.changeQualityOf(this.getQualityAmountToChange());
        if (this.getQuality() < 0)
            this.setQuality(0);
        this.sellInPassed();
    }
}
