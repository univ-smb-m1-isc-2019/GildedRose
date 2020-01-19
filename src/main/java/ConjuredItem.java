public class ConjuredItem implements ItemInterface {
    private ItemHolder item;

    public ConjuredItem(ItemHolder item) {
        this.item = item;
    }

    @Override
    public void changeQualityOf(int n) {
        this.item.changeQualityOf(n);
    }

    @Override
    public void sellInPassed() {
        this.item.sellInPassed();
    }

    @Override
    public String getName() {
        return this.item.getName();
    }

    @Override
    public void setName(String name) {
        this.item.setName(name);
    }

    @Override
    public int getSellIn() {
        return this.item.getSellIn();
    }

    @Override
    public void setSellIn(int sellIn) {
        this.item.setSellIn(sellIn);
    }

    @Override
    public int getQuality() {
        return this.item.getQuality();
    }

    @Override
    public void setQuality(int quality) {
        this.item.setQuality(quality);
    }

    @Override
    public void updateQuality() {
        this.item.updateQuality();
    }

    @Override
    public int getQualityAmountToChange() {
        int amount = this.item.getQualityAmountToChange();
        if (amount < 0)
            return 2 * amount;
        else
            return amount;
    }

    @Override
    public int getMaximumQuality() {
        return this.item.getMaximumQuality();
    }
}
