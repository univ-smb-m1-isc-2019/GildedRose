import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

	List<Item> items;
	private Updater updater;
    static List<Item> standardItems = null;
    static List<Item> conjuredItems = null;
	GildedRose(){
        updater = new Updater();
	    this.items = createList();
	    initStandardList();
	    initConjuredList();
    }
    private List<Item> createList(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 0, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }
    private void initStandardList(){
        standardItems = new ArrayList<>();
        Item vest = get("+5 Dexterity Vest");
        Item elixir = get("Elixir of the Mongoose");
        standardItems.add(vest);
        standardItems.add(elixir);
    }
    private void initConjuredList(){
        conjuredItems = new ArrayList<>();
        Item cake = get("Conjured Mana Cake");
        conjuredItems.add(cake);
    }
    void display(){
        for (Item it : items){
            System.out.println("Name : " + it.getName());
            System.out.println("SellIn : " + it.getSellIn());
            System.out.println("Quality : " + it.getQuality() + "\n");
        }
    }
    Item get(String name){
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
    void updateQuality()
    {

        for (Item it : items)
        {
            if (standardItems.contains(it))
            {
                updater.standardItemUpdate.updateQuality(it);
            }
            else if(conjuredItems.contains(it)){
                updater.conjuredItemUpdate.updateQuality(it);
            }
            else
            {
                if (it.getName().equals("Aged Brie"))
                    updater.agedBrieUpdate.updateQuality(it);

                if (it.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
                    updater.backstageUpdater.updateQuality(it);

            }

            if (!"Sulfuras, Hand of Ragnaros".equals(it.getName()))
                it.setSellIn(it.getSellIn() - 1);


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
                                if (conjuredItems.contains(it)){
                                    updater.conjuredItemUpdate.updateQuality(it);
                                }else {
                                    it.setQuality(it.getQuality() - 1);
                                }

                            }
                        }
                    }
                    else
                    {
                        it.setQuality(0);
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