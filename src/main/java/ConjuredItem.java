public class ConjuredItem extends AbstractItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if(!hasReachMinQuality() && !hasReachSellInBoundary()) item.quality -= 2;
        else if(!hasReachMinQuality()) item.quality -= 4;
        if(hasReachMinQuality()) item.quality = MIN_QUALITY;
    }

}
