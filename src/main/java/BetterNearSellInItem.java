public class BetterNearSellInItem extends SpecializedItem{

    private final static int FIRST_LEVEL = 10;
    private final static int FIRST_LEVEL_IMPROVE = 2;
    private final static int SECOND_LEVEL = 5;
    private final static int SECOND_LEVEL_IMPROVE = 3;


    public BetterNearSellInItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    //Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
    public void updateQuality(){
        if(this.sellIn <= 0){
            this.quality=0;
        }
        else{
            if(this.sellIn<=SECOND_LEVEL){
                this.quality +=SECOND_LEVEL_IMPROVE;
            }
            else{
                if( this.sellIn <= FIRST_LEVEL){
                    this.quality+=FIRST_LEVEL_IMPROVE;
                }
                else{ this.quality +=1;
                }
            }
        }
        if ( this.quality > QUALITY_MAX){
            this.quality = QUALITY_MAX;
        }
        this.sellIn -=1;
    }
}
