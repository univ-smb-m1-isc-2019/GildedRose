public class BackstagePasses extends AbstractItem {

    protected static final int CLOSE_DATE = 10;
    protected static final int IMMINENT_DATE = 5;

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.quality += 1;
        if(hasReachCloseDate()) item.quality += 1;
        if(hasReachImminentDate()) item.quality += 1;
        if(hasReachSellInBoundary()) item.quality = MIN_QUALITY;
        if(hasReachMaxQuality()) item.quality = MAX_QUALITY;
    }

    protected boolean hasReachCloseDate() {
        return item.sellIn < CLOSE_DATE;
    }

    protected boolean hasReachImminentDate() {
        return item.sellIn < IMMINENT_DATE;
    }
}
