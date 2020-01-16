import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    Map<String, AbstractItem> classes;

    public ItemFactory(Item item) {
        this.classes = new HashMap<>();

        classes.put("Sulfuras, Hand of Ragnaros", new Legendary(item));
    }

    public AbstractItem getClass(String name) {
        return classes.get(name);
    }
}
