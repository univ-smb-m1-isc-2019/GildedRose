import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

	List<Item> items;
	GildedRose(){
	    this.items = createList();
    }
    private List<Item> createList(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 0, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 1, 30));
        return items;
    }

    void updateQuality()
    {
        UpdateQuality updateQuality = new UpdateQuality();
        for (Item it : items)
        {
            updateQuality.updateItem(it);
        }
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
}