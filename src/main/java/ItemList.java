import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private static List<AdvancedItem> legendaryItems= null ;


        public  List<AdvancedItem> createList() {
        List<AdvancedItem> itemList = new ArrayList<AdvancedItem>();
        List<AdvancedItem> legendaryItems = new ArrayList<AdvancedItem>();
        itemList.add( new AdvancedItem(new Item("+5 Dexterity Vest", 10, 20),false));
        itemList.add(new AdvancedItem(new Item("Aged Brie", 2, 0),false));
        itemList.add(new AdvancedItem(new Item("Elixir of the Mongoose", 5, 7),false));

        itemList.add(new AdvancedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false));
        legendaryItems.add(new AdvancedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false));

        itemList.add(new AdvancedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),false));
        itemList.add(new AdvancedItem(new Item("Conjured Mana Cake", 3, 6) ,true));
        return itemList;
    }


    public String toString(List<AdvancedItem> itemList) {
        String res = "";
        for (AdvancedItem items : itemList ){
            Item item = items.getItem();

            res  += item.name +  " sellin : " +item.sellIn + " quality : " + item.quality +"\n";

    }
      /*  itemList.forEach(Citem ->{  Item item = Citem.getItem();
       res  += item.name +  " sellin : " +item.sellIn + " quality : " + item.quality +"\n"; } );*/

        return res;
    }

    public static List<AdvancedItem> getLegendaryItems() {
        return legendaryItems;
    }

    public static void setLegendaryItems(List<AdvancedItem> legendaryItems) {
        ItemList.legendaryItems = legendaryItems;
    }
}
