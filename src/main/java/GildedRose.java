import java.util.ArrayList;
import java.util.List;


public class GildedRose {


    private List<Item> items;

    public GildedRose() {
        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }


    public Item getItem(String s) {
        int i = 0;
        boolean trouve = false;
        Item res = null;
        while (!trouve) {
            if (s.equals(items.get(i).getName())) {
                trouve = true;
                res = items.get(i);
            }
            i++;
        }
        return res;
    }

    public void updateQuality() {
        for (Item item : items) {
            MeilleurItem mitem = getTypeItem(item);
            mitem.updateQuality();
        }
    }

    private MeilleurItem getTypeItem(Item item) {
        return new ItemType(item).setType(item);
    }

    public List<Item> getListItems() {
        return items;
    }
}
