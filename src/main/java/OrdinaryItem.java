public class OrdinaryItem extends AbstractItem {

    public OrdinaryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if(!hasReachQualityBoundary() && !hasReachSellInBoundary()) {
            item.quality--;
        }
        else if(!hasReachQualityBoundary()) {
            item.quality = item.quality - 2;
        }
    }

}
