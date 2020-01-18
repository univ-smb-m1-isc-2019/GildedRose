public class CheeseItem extends  CustomItem {
    private static final int QUALITY_INCREASE = 1;

    public CheeseItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn -= 1;

        if(item.sellIn > 0){
            item.quality += QUALITY_INCREASE;
        } else {
            item.quality += QUALITY_INCREASE * 2;
        }

        checkQualityInbounds();
    }
}
