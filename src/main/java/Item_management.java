public class Item_management {

    public static int QUALITY_MAX = 50;
    public static int QUALITY_MIN = 0;
    private static String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";

    public boolean qualityLessThan50 (Item myItem){
       return myItem.getQuality() < QUALITY_MAX;
    }

    public void qualityIncrementBackstage(Item myItem){

        if (myItem.getSellIn() < 11)
            if (qualityLessThan50(myItem)) {
                myItem.setQuality(myItem.getQuality() + 1);
            }

        if (myItem.getSellIn() < 6)
            if (qualityLessThan50(myItem)) {
                myItem.setQuality(myItem.getQuality() + 1);
            }
    }

    public void itemQualityDecrement(Item myItem){
        if (myItem.getQuality() > QUALITY_MIN)
            myItem.setQuality(myItem.getQuality() - 1);
    }

    public void dayPassed(Item myItem){
            if (!LEGENDARY_ITEM.equals(myItem.getName()))
                itemQualityDecrement(myItem);
    }


}
