public class Item_management {

    public static int QUALITY_MAX = 50;
    public static int QUALITY_MIN = 0;
    private static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";

    public boolean isLegendaryItem(Item myItem){
        return LEGENDARY_ITEM.equals(myItem.getName());
    }

    public void itemQualityIncrement(Item myItem){
        if (myItem.getQuality() < QUALITY_MAX)
            myItem.setQuality(myItem.getQuality() + 1);
    }

    public void itemQualityDecrement(Item myItem){
        if (myItem.getQuality() > QUALITY_MIN && !isLegendaryItem(myItem))
            myItem.setQuality(myItem.getQuality() - 1);
    }

    public void dayPassed(Item myItem){
        if (!isLegendaryItem(myItem))
            myItem.setSellIn(myItem.getSellIn() - 1);
    }

    public void qualityIncrementBackstage(Item myItem){

        if (myItem.getSellIn() < 11)
            itemQualityIncrement(myItem);

        if (myItem.getSellIn() < 6)
                itemQualityIncrement(myItem);
    }


}
