import java.util.ArrayList;
import java.util.List;


public class GildedRose {


    private List<Item> items;
    private List<MeilleurItem> mitems;

    public GildedRose() {
        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrie("Aged Brie", 2, 0));
        items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
        items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
        mitems = new ArrayList<MeilleurItem>();
        convertItems();
    }

    //convertit la liste de Item en list de MeilleurItem
    public void convertItems() {
        for (Item item : items) {
            System.out.println(item.getName());
            mitems.add(new MeilleurItem(item.getName(), item.getSellIn(), item.getQuality()));
        }
    }

    public List<MeilleurItem> getListItems() {
        return mitems;
    }

    public MeilleurItem getItem(String s) {
        int i = 0;
        boolean trouve = false;
        MeilleurItem res = null;
        while (!trouve) {
            if (!s.equals(mitems.get(i).getName())) {
                trouve = true;
                res = mitems.get(i);
            }
            i++;
        }
        return res;
    }

    public void updateQuality() {
        for (MeilleurItem item : mitems)
            item.updateQuality();
    }
}
