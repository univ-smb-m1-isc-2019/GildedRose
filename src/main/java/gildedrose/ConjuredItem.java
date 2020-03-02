package gildedrose;

public class ConjuredItem extends CustomItem{
    private static final int QUALITY_DECREASE = 2;

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn -= 1;

        if(item.sellIn > 0){
            item.quality -= QUALITY_DECREASE;
        } else {
            item.quality -= QUALITY_DECREASE * 2;
        }

        checkQualityInbounds();
    }

}
