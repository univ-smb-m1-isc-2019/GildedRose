import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemFactory {
    Map<String, Class<? extends AbstractItem>> instances;

    public ItemFactory() {
        this.instances = new HashMap<>();

        instances.put("Sulfuras, Hand of Ragnaros", LegendaryItem.class);
        instances.put("Dexterity Vest", OrdinaryItem.class);
        instances.put("Elixir of the Mongoose", OrdinaryItem.class);
        instances.put("Aged Brie", AgedBrie.class);
        instances.put("Backstage passes", BackstagePasses.class);
    }

    // return the instance corresponding to the given item.
    public AbstractItem getInstance(Item item) throws Exception {
        // deal with stuff like conjured items, that has "conjured" in their name, as an example.
        Optional<String> similarName = findFirstKeyInString(item.name);

        if(similarName.isPresent()) {
            return (AbstractItem) instances
                    .get(similarName.get())
                    .getConstructor(Item.class)
                    .newInstance(item);
        } else {
            throw new Exception("There is no item called this way in our world! Are you sure you're playing WOW?");
        }
    }

    private Optional<String> findFirstKeyInString(String str) {
        return instances.keySet()
                .stream()
                .filter(key -> str.contains(key))
                .findFirst();
    }

}
