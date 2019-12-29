public class AgedBrie extends CustomItem{

    private static final int QUALITY_EVOLUTION_BEFORE_SELL_DATE = 1;
    private static final int QUALITY_EVOLUTION_AFTER_SELL_DATE = 2;

    public AgedBrie(Item item){
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn -= 1;
        if(!hasReachedHighestQualityPossible()) {

            if(!hasSellDatePassed()){
                item.quality += QUALITY_EVOLUTION_BEFORE_SELL_DATE;
            }
            else{
                item.quality += QUALITY_EVOLUTION_AFTER_SELL_DATE;
            }

            checkQualityLimitReached();
        }
    }
}
