public class ConjuredItem extends Item{

    private static final int DECAY = 2;

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality(){
        if (this.sellIn<=0){
            setQuality(quality - DECAY*2);
        }
        else {
            setQuality(quality - DECAY);
        }
        if(quality < 0){
            quality =0;
        }
        this.sellIn-=1;
    }
}

