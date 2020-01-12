public class Item_management {

    public static int QUALITY_MAX = 50;
    public static int QUALITY_MIN = 0;
    private static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";

    /**Return true if the item is legendary **/
    public boolean isLegendaryItem(Item myItem){
        return LEGENDARY_ITEM.equals(myItem.getName());
    }

    /**Increment quality of item **/
    public void itemQualityIncrement(Item myItem){
        if (myItem.getQuality() < QUALITY_MAX)
            myItem.setQuality(myItem.getQuality() + 1);
    }

    /**Decrement quality of item **/
    public void itemQualityDecrement(Item myItem){
        if (myItem.getQuality() > QUALITY_MIN && !isLegendaryItem(myItem))
            myItem.setQuality(myItem.getQuality() - 1);
    }

    /**Decrement remaining days of selling **/
    public void dayPassed(Item myItem){
        if (!isLegendaryItem(myItem))
            myItem.setSellIn(myItem.getSellIn() - 1);
    }

    /**Increment quality of "Backstage passes to a TAFKAL80ETC concert" item **/
    public void qualityIncrementBackstage(Item myItem){

        if (myItem.getSellIn() < 11)
            itemQualityIncrement(myItem);

        if (myItem.getSellIn() < 6)
                itemQualityIncrement(myItem);
    }


}
