import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<ConjuredItem> conjuredItem = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        conjuredItem = new ArrayList<ConjuredItem>();
        conjuredItem.add( new ConjuredItem(new Item("+5 Dexterity Vest", 10, 20),false));
        conjuredItem.add(new ConjuredItem(new Item("Aged Brie", 2, 0),false));
        conjuredItem.add(new ConjuredItem(new Item("Elixir of the Mongoose", 5, 7),false));
        conjuredItem.add(new ConjuredItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false));
        conjuredItem.add(new ConjuredItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),false));
        conjuredItem.add(new ConjuredItem(new Item("Conjured Mana Cake", 3, 6) ,true));
	    /*
        System.out.println("OMGHAI!");
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
*/
        updateQuality();

        conjuredItem.forEach(Citem ->{  Item item = Citem.getItem();System.out.println(item.name +  " sellin : " +item.sellIn + " quality : " + item.quality ); } );
       // System.out.println(items) ;
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < conjuredItem.size(); i++)
        {
            Item items = conjuredItem.get(i).getItem();
            int conjured =  conjuredItem.get(i).getConjured() ? 2 : 1 ;
            if ((!"Aged Brie".equals(items.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
            {
                if (items.getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.getName()))
                    {
                        items.setQuality(items.getQuality() - conjured);
                    }
                }
            }
            else
            {
                if (items.getQuality() < 50)
                {
                    items.setQuality(items.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
                    {
                        if (items.getSellIn() < 11)
                        {
                            if (items.getQuality() < 50)
                            {
                                items.setQuality(items.getQuality() + 1);
                            }
                        }

                        if (items.getSellIn() < 6)
                        {
                            if (items.getQuality() < 50)
                            {
                                items.setQuality(items.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.getName()))
            {
                items.setSellIn(items.getSellIn() - 1);
            }

            if (items.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
                    {
                        if (items.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.getName()))
                            {
                                items.setQuality(items.getQuality() - conjured);
                            }
                        }
                    }
                    else
                    {
                        items.setQuality(items.getQuality() - items.getQuality());
                    }
                }
                else
                {
                    if (items.getQuality() < 50)
                    {
                        items.setQuality(items.getQuality() + 1);
                    }
                }
            }
        }
    }

}