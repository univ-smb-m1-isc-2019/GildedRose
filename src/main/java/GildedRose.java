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
                    if (item.getQuality() > 0)
                        myManagement.dayPassed(item);

            }else{

                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                        myManagement.qualityIncrementBackstage(item);
                    }


                }
            }

            myManagement.dayPassed(item);/**/

            if (item.getSellIn() < 0) {
                sellInLessThan0(item);
            }

        }
    }


    private void sellInLessThan0(Item myitem){
        if (!"Aged Brie".equals(myitem.getName())) {
            if (!"Backstage passes to a TAFKAL80ETC concert".equals(myitem.getName())) {

                if (myitem.getQuality() > 0) {
                    myManagement.dayPassed(myitem);/**/
                }



            }else{
                myitem.setQuality(myitem.getQuality() - myitem.getQuality());
            }
        }else{
            if (myitem.getQuality() < 50){
                myitem.setQuality(myitem.getQuality() + 1);
            }
        }
    }

}