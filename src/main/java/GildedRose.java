import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static List<ItemInterface> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<ItemInterface>();
        items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
        items.add(new CollectorItem("Aged Brie", 2, 0));
        items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
        items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new TakeItBeforeTooLateItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ConjuredItem(new NormalItem("Conjured Mana Cake", 3, 6)));

        updateQuality();
    }


    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++)
            items.get(i).updateQuality();
    }
}