import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    Map<String, Class<? extends AbstractItem>> instances;

    public ItemFactory() {
        this.instances = new HashMap<>();

        instances.put("Sulfuras, Hand of Ragnaros", LegendaryItem.class);
        instances.put("+5 Dexterity Vest", OrdinaryItem.class);
        instances.put("Elixir of the Mongoose", OrdinaryItem.class);
        instances.put("Aged Brie", AgedBrie.class);
        instances.put("Backstage passes to a TAFKAL80ETC concert", BackstagePasses.class);
    }

    // return the instance corresponding to the given item.
    public AbstractItem getInstance(Item item) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = instances.get(item.name);
        return (AbstractItem) c.getConstructor(Item.class).newInstance(item);
    }
}
