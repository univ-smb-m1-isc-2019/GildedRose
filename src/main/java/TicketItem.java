public class TicketItem extends CustomItem{
    private static final int QUALITY_INCREASE = 1;

    public TicketItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        item.sellIn -= 1;

        if(item.sellIn > 0){
            item.quality += QUALITY_INCREASE;
            if(item.sellIn <= 10 && item.sellIn > 5){
                item.quality += QUALITY_INCREASE;
            }
            if(item.sellIn < 5) item.quality += QUALITY_INCREASE*2;
        } else {
            item.quality = 0;
        }

        checkQualityInbounds();
    }
}
