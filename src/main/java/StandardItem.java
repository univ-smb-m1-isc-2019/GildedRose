public class StandardItem extends CustomItem {
    private static final int QUALITY_DECREASE = 1;

    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn -= 1;

        if(sellIn > 0){
            item.quality -= QUALITY_DECREASE;
        } else {
            item.quality -= QUALITY_DECREASE * 2;
        }

        checkQualityInbounds();
    }

}
