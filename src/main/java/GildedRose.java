import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

    private List<Item> items = null;

    public GildedRose() {
        items = new ArrayList<Item>();
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Aged Brie", 2, 0));
    }

    public void updateQuality() throws Exception {
        ItemFactory itemFactory = new ItemFactory();

        for (Item item : items) {
            itemFactory.getClass(item).update();
        }
    }

    public Item get(String key) {
        Optional<Item> optional = items.stream().filter(item -> item.getName().equals(key)).findFirst();
        if(optional.isPresent()) {
            return optional.get();
        }
        else {
            throw new IllegalStateException("not found in shop");
        }
    }

}