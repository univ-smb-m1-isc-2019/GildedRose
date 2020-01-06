import java.util.ArrayList;
import java.util.List;

public class Stock {
    public  List<CorruptedItem> addAllItem(List<CorruptedItem> items){
        items = new ArrayList<CorruptedItem>();
        CorruptedItem item1 = new CorruptedItem(new Item("+5 Dexterity Vest", 10, 20),false);
        CorruptedItem item2 = new CorruptedItem(new Item("Aged Brie", 2, 0),false);
        CorruptedItem item3 = new CorruptedItem(new Item("Elixir of the Mongoose", 5, 7),false);
        CorruptedItem item4 = new CorruptedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false);
        CorruptedItem item5 = new CorruptedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),false);
        CorruptedItem item6 = new CorruptedItem(new Item("Conjured Mana Cake", 3, 6),true);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        return items;
    }
}
