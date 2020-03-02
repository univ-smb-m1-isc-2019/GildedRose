package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private final List<GenericItem> items;

    public GildedRose() {
        items = new ArrayList<>();
    }

    public void add(Item item) {

        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            items.add(new Sulfuras(item));
            return;
        }

        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            items.add(new BackstagePass(item));
            return;
        }

        if ("Aged Brie".equals(item.getName())) {
            items.add(new AgedBrie(item));
            return;
        }

        this.items.add(new GenericItem(item));
    }

    public void updateQuality() {
        items.forEach(GenericItem::checks);
    }

}