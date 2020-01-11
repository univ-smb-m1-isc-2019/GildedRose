import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private Item_management myManagement;
    private static List<Item> items;

    public GildedRose(List<Item> items){
        this.myManagement = new Item_management();
        this.items = items;
    }

    public void updateQuality(){

        for (Item item: this.items) {

            if ((!"Aged Brie".equals(item.getName()))) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    myManagement.itemQualityDecrement(item);

            }else{

                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                        myManagement.qualityIncrementBackstage(item);

                }
            }

            myManagement.dayPassed(item);/**/

            if (item.getSellIn() < 0) {
                sellInLessThan0(item);
            }

        }
    }


    private void sellInLessThan0(Item myItem){
        if (!"Aged Brie".equals(myItem.getName())) {
            if (!"Backstage passes to a TAFKAL80ETC concert".equals(myItem.getName())) {
                myManagement.itemQualityDecrement(myItem);
            }else
                myItem.setQuality(myItem.getQuality() - myItem.getQuality());
        }else
            myManagement.itemQualityIncrement(myItem);
    }

}