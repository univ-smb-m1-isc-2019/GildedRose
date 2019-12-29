public class BackstagePasses extends CustomItem{

    private static final int CLOSE_CONCERT_DATE = 10;
    private static final int IMMINENT_CONCERT_DATE = 5;

    public BackstagePasses(Item item){
        super(item);
    }

    @Override
    public void updateItem() {
        item.quality += 1;
        if(item.sellIn <= CLOSE_CONCERT_DATE) item.quality += 1;
        if(item.sellIn <= IMMINENT_CONCERT_DATE) item.quality += 1;

        item.sellIn -= 1;

        if(hasSellDatePassed()) item.quality = GildedRose.LOWEST_QUALITY_POSSIBLE;

        checkQualityLimitReached();
    }
}
