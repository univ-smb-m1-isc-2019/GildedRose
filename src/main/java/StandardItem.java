public class StandardItem extends ItemType {
    private static final int QUALITY_DECREASE = 1;

    public StandardItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        int sellIn = this.sellIn;
        int quality = this.quality;

        sellIn -= 1;

        if(sellIn > 0){
            quality -= QUALITY_DECREASE;
        } else {
            quality -= QUALITY_DECREASE * 2;
        }

        checkQualityInbounds();
    }

}
