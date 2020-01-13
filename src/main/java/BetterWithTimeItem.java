public class BetterWithTimeItem extends Item {

    private static final int IMPROVE = 1;

    public BetterWithTimeItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        if(this.quality <50){
            quality += IMPROVE;
        }
        this.sellIn-=1;
    }
}
