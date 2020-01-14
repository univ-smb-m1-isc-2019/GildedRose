import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class GildedRose {

	public List<Item> items = null;
    public static List<Item> notStandardItems = null;
	public GildedRose(){

	    this.items = createList();
	    initNotStandardList();
    }
    public List<Item> createList(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 0, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }
    public void initNotStandardList(){
        notStandardItems = new ArrayList<>();
        Item sulfuras = get("Sulfuras, Hand of Ragnaros");
        Item agedBrie = get("Aged Brie");
        Item backstage = get("Backstage passes to a TAFKAL80ETC concert");
        Item conjuredManaCake = get("Conjured Mana Cake");
        notStandardItems.add(sulfuras);
        notStandardItems.add(agedBrie);
        notStandardItems.add(backstage);
        notStandardItems.add(conjuredManaCake);
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