import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static List<ItemHolder> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<ItemHolder>();
        items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
        items.add(new ItemHolder(new Item("Aged Brie", 2, 0)));
        items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
        items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new ItemHolder(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)));
        items.add(new ItemHolder(new Item("Conjured Mana Cake", 3, 6)));

        updateQuality();
    }


    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++)
            items.get(i).updateQuality();
    }
}