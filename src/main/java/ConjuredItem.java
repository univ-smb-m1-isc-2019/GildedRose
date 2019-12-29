public class ConjuredItem extends CustomItem {

    private static final int QUALITY_EVOLUTION_BEFORE_SELL_DATE = 2;
    private static final int QUALITY_EVOLUTION_AFTER_SELL_DATE = 4;

    public ConjuredItem(Item item){
        super(item);
    }

    @Override
    public void updateItem() {
        item.sellIn -= 1;
        if(!hasReachedLowestQualityPossible()) {

            if(!hasSellDatePassed()){
                item.quality -= QUALITY_EVOLUTION_BEFORE_SELL_DATE;
            }
            else{
                item.quality -= QUALITY_EVOLUTION_AFTER_SELL_DATE;
            }

            checkQualityLimitReached();
        }
    }
}
