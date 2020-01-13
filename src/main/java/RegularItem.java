public class RegularItem extends Item {

    private static final int DECAY = 1;

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(sellIn <= 0){
            this.quality -= DECAY *2;
        }
        else{
            this.quality -= DECAY;
        }

        if(this.quality < 0){
            quality =0;
        }

        this.sellIn -=1;
    }
}
