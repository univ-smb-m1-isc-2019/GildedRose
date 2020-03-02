package gildedrose;

public abstract class CustomItem {
    static final int LOWEST_QUALITY = 0;
    static final int HIGHEST_QUALITY = 50;

    protected Item item;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateItemQuality();

    protected boolean isQualityTooLow(){
        return item.quality <= LOWEST_QUALITY;
    }

    protected boolean isQualityTooHigh(){
        return item.quality >= HIGHEST_QUALITY;
    }

    protected void checkQualityInbounds(){
        if(isQualityTooLow()){
            item.quality = LOWEST_QUALITY;
        } else if(isQualityTooHigh())
            item.quality = HIGHEST_QUALITY;
    }

}
