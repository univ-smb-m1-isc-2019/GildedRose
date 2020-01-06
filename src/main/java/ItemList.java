import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private static String res ="";

    public  List<AdvancedItem> createList() {
        List<AdvancedItem> itemList = new ArrayList<AdvancedItem>();
        itemList.add( new AdvancedItem(new Item("+5 Dexterity Vest", 10, 20),false));
        itemList.add(new AdvancedItem(new Item("Aged Brie", 2, 0),false));
        itemList.add(new AdvancedItem(new Item("Elixir of the Mongoose", 5, 7),false));
        itemList.add(new AdvancedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false));
        itemList.add(new AdvancedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),false));
        itemList.add(new AdvancedItem(new Item("Conjured Mana Cake", 3, 6) ,true));
        return itemList;
    }


    public String toString(List<AdvancedItem> itemList) {

        itemList.forEach(Citem ->{  Item item = Citem.getItem();
                                res += item.name +  " sellin : " +item.sellIn + " quality : " + item.quality +"\n"; } );

        return res;
    }
}
