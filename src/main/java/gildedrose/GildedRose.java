package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private final List<ItemWrapper> items;

    public GildedRose() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        this.items.add(new ItemWrapper(item));
    }

    public void updateQuality() {
        items.forEach(ItemWrapper::updateQuality);
    }

}