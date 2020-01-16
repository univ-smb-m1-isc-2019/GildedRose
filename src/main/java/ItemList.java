import java.util.ArrayList;
import java.util.List;

public class ItemList {

    public List<ResetItem> init() {
        List<ResetItem> itemList = new ArrayList<ResetItem>();
        itemList.add(new ResetItem(new Item("+5 Dexterity Vest", 10, 20), false));
        itemList.add(new ResetItem(new Item("Aged Brie", 2, 0), true));
        itemList.add(new ResetItem(new Item("Elixir of the Mongoose", 5, 7), false));
        itemList.add(new ResetItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80), false));
        itemList.add(new ResetItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), false));
        itemList.add(new ResetItem(new Item("Conjured Mana Cake", 3, 6), true));
        return itemList;
    }

    public String toString(List<ResetItem> itemList) {
        String res = "";
        for (int i = 0; i < itemList.size(); i++) {
            res += "Name : " + itemList.get(i).getItem().getName() + " | SellIn : " + itemList.get(i).getItem().getSellIn()
                    + " , Quality : " + itemList.get(i).getItem().getQuality() + "\n";
        }
        return res;
    }
}
