public class BetterWithTimeItem extends SpecializedItem {

    private static final int IMPROVE = 1;

    public BetterWithTimeItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    //increases in Quality the older it gets
    public void updateQuality(){
        if(this.quality < QUALITY_MAX){
            quality += IMPROVE;
        }
        this.sellIn-=1;
    }
}
