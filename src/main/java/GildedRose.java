import java.util.ArrayList;


public class GildedRose  {

	private static ArrayList<ItemCreate> items = null;

    public GildedRose(String name, int sellIn, int quality) {

    }

    /**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<ItemCreate>();
        items.add(new ItemCreate("+5 Dexterity Vest", 10, 20));
        items.add(new ItemCreate("Aged Brie", 2, 0));
        items.add(new ItemCreate("Elixir of the Mongoose", 5, 7));
        items.add(new ItemCreate("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new ItemCreate("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ItemCreate("Conjured Mana Cake", 3, 6));

}



     protected void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)

        {
            ItemCreate item=  items.get(i);
            item.doUpdateQuality();
        }
    }

}
