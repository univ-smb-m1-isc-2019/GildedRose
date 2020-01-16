import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    Map<String, Class<? extends AbstractItem>> classes;

    public ItemFactory() {
        this.classes = new HashMap<>();

        classes.put("Sulfuras, Hand of Ragnaros", Legendary.class);
    }

    public AbstractItem getClass(Item item) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = classes.get(item.name);
        return (AbstractItem) c.getConstructor(Item.class).newInstance(item);
    }
}
