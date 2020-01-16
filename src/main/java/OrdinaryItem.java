public class OrdinaryItem extends AbstractItem {

    public OrdinaryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if(!hasReachMinQuality() && !hasReachSellInBoundary()) item.quality = item.quality - 1;
        else if(!hasReachMinQuality()) item.quality = item.quality - 2;
        if(hasReachMinQuality()) item.quality = MIN_QUALITY;
    }

}
