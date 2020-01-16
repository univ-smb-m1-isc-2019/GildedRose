package factory;

public class AgedBrie extends AbstractItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if(!hasReachSellInBoundary()) item.quality++;
        else if(!hasReachMaxQuality()) item.quality += 2;
        if(hasReachMaxQuality()) item.quality = MAX_QUALITY;
    }

}
