package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
    private static int LOWEST_QUALITY_POSSIBLE = 0;
    private static int HIGHEST_QUALITY_POSSIBLE = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}



    public static void updateQuality()
    {
        for (Item item: items)
        {
            if ((!"Aged Brie".equals(item.name)) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.name))
            {
                if (item.quality > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
                    {
                        item.quality -= 1;
                    }
                }
            }
            else
            {
                if (item.quality < 50)
                {
                    item.quality += 1;

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name))
                    {
                        if (item.sellIn < 11)
                        {
                            if (item.quality < 50)
                            {
                                item.quality += 1;
                            }
                        }

                        if (item.sellIn < 6)
                        {
                            if (item.quality < 50)
                            {
                                item.quality += 1;
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
            {
                item.setSellIn(item.sellIn - 1);
            }

            if (item.sellIn < 0)
            {
                if (!"Aged Brie".equals(item.name))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.name))
                    {
                        if (item.quality > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
                            {
                                item.quality -= 1;
                            }
                        }
                    }
                    else
                    {
                        item.quality = item.quality - item.quality;
                    }
                }
                else
                {
                    if (item.quality < 50)
                    {
                        item.quality += 1;
                    }
                }
            }
        }
    }

}