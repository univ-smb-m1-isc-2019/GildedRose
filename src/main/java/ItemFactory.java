import items.AbstractItem;
import items.Legendary;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    Map<String, AbstractItem> classes;

    public ItemFactory() {
        this.classes = new HashMap<>();

        classes.put("Sulfuras, Hand of Ragnaros", new Legendary());
    }

    public AbstractItem getClass(String name) {
        return classes.get(name);
    }
}
