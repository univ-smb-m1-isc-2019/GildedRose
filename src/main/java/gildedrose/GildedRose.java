package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private final List<ItemWrapper> items;

    public GildedRose() {
        items = new ArrayList<>();
    }

    public void add(Item item) {

        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            items.add(new Sulfuras(item));
            return;
        }

        ItemWrapper wrapper = new ItemWrapper(item);

        if (wrapper.isBackstagePass(item)) {
            items.add(new BackstagePass(item));
            return;
        }

        this.items.add(wrapper);
    }

    public void updateQuality() {
        items.forEach(ItemWrapper::updateQuality);
    }

}