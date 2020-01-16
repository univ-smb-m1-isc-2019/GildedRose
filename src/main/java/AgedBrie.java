public class AgedBrie extends AbstractItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if(!hasReachSellInBoundary() && !hasReachMaxQuality()) {
            item.quality++;
        }
        else if(!hasReachMaxQuality()) {
            item.quality = item.quality + 2;
        }
    }
}
