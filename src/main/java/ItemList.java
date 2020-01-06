import java.util.ArrayList;
import java.util.List;

public class ItemList {

    public List<AmelioratedItem> init() {
        List<AmelioratedItem> itemlist = new ArrayList<AmelioratedItem>();
        itemlist.add(new AmelioratedItem(("+5 Dexterity Vest", 10, 20), false));
        itemlist.add(new AmelioratedItem(("Aged Brie", 2, 0), true));
        itemlist.add(new AmelioratedItem(("Elixir of the Mongoose", 5, 7), false));
        itemlist.add(new AmelioratedItem(("Sulfuras, Hand of Ragnaros", 0, 80), false));
        itemlist.add(new AmelioratedItem(("Backstage passes to a TAFKAL80ETC concert", 15, 20), false));
        itemlist.add(new AmelioratedItem(("Conjured Mana Cake", 3, 6), true));
        return itemlist;
    }

    public String toString(List<AmelioratedItem> itemlist) {
        String res = "";
        for (int i = 0; i < itemlist.size(); i++) {
            res += "Name : " + itemlist.get(i).getItem().getName() + " | SellIn : " + itemlist.get(i).getItem().getSellIn()
                    + " , Quality : " + itemlist.get(i).getItem().getQuality() + "\n";
        }
        return res;
    }
}
