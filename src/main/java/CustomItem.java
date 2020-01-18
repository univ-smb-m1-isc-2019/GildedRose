public abstract class CustomItem {
    static final int LOWEST_QUALITY = 0;
    static final int HIGHEST_QUALITY = 50;

    protected Item item;
    public int quality;
    public int sellIn;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateItemQuality();

    protected boolean isQualityTooLow(){
        return quality < LOWEST_QUALITY;
    }

    protected boolean isQualityTooHigh(){
        return quality > HIGHEST_QUALITY;
    }

    protected void checkQualityInbounds(){
        if(isQualityTooLow()){
            quality = LOWEST_QUALITY;
        } else if(isQualityTooHigh())
            quality = HIGHEST_QUALITY;
    }


}
