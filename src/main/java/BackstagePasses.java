public class BackstagePasses extends improveItem {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void udpdateSellIn() {
        decrementItemSellIn();
    }
    private void decrementItemSellIn() {
        setSellIn(getSellIn()-1);
    }

}
