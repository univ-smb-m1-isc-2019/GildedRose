import java.util.List;

public class GildedRose {

    private static String AGED_BRIE = "Aged Brie";
    private static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private Item_management myManagement;
    private static List<Item> items;

    public GildedRose(List<Item> items){
        this.myManagement = new Item_management();
        this.items = items;
    }

    public void updateQuality(){
        for (Item item: this.items) {

            if ((!AGED_BRIE.equals(item.getName())) && !(BACKSTAGE_PASSES.equals(item.getName())))
                myManagement.itemQualityDecrement(item);

            else{
                myManagement.itemQualityIncrement(item);
                if (BACKSTAGE_PASSES.equals(item.getName()))
                    myManagement.qualityIncrementBackstage(item);
            }

            myManagement.dayPassed(item);

            if (item.getSellIn() < 0)
                sellIn_LessThan0(item);
        }
    }

/**Management quality of item if days for selling were exceeded **/
    private void sellIn_LessThan0(Item myItem){
        if (!AGED_BRIE.equals(myItem.getName())) {
            if (!BACKSTAGE_PASSES.equals(myItem.getName()))
                myManagement.itemQualityDecrement(myItem);
            else
                myItem.setQuality(myItem.getQuality() - myItem.getQuality());
        }else
            myManagement.itemQualityIncrement(myItem);
    }

}