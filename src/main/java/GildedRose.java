import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

	public static List<Item> items = null;

	public GildedRose(){
        createList();
    }
    public void createList(){
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }
    public void display(){
        for (Item it : items){
            System.out.println("Name : " + it.getName());
            System.out.println("SellIn : " + it.getSellIn());
            System.out.println("Quality : " + it.getQuality() + "\n");
        }
    }
    public Item get(String name){
        Optional<Item> optional = items
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new IllegalStateException("not in shop");
        }
    }
    public void updateQuality()
    {

        for (Item it : items)
        {
            if ((!"Aged Brie".equals(it.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(it.getName())) 
            {
                if (it.getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(it.getName()))
                    {
                        it.setQuality(it.getQuality() - 1);
                    }
                }
            }
            else
            {
                if (it.getQuality() < 50)
                {
                    it.setQuality(it.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(it.getName()))
                    {
                        if (it.getSellIn() < 11)
                        {
                            if (it.getQuality() < 50)
                            {
                                it.setQuality(it.getQuality() + 1);
                            }
                        }

                        if (it.getSellIn() < 6)
                        {
                            if (it.getQuality() < 50)
                            {
                                it.setQuality(it.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(it.getName()))
            {
                it.setSellIn(it.getSellIn() - 1);
            }

            if (it.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(it.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(it.getName()))
                    {
                        if (it.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(it.getName()))
                            {
                                it.setQuality(it.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        it.setQuality(it.getQuality() - it.getQuality());
                    }
                }
                else
                {
                    if (it.getQuality() < 50)
                    {
                        it.setQuality(it.getQuality() + 1);
                    }
                }
            }
        }
    }

}