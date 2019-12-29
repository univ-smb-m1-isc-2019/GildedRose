public abstract class CustomItem {

    private Item item;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateItem();

    protected boolean hasSellDatePassed(){
        return item.sellIn < 0;
    }

    protected boolean hasHighestQualityPossible(){
        return item.quality >= GildedRose.HIGHEST_QUALITY_POSSIBLE;
    }

    protected boolean hasLowestQualityPossible(){
        return item.quality <= GildedRose.LOWEST_QUALITY_POSSIBLE;
    }
}
