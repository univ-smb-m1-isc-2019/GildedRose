package gildedrose;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private final List<Item> items;


    public GildedRose() {
        items = new ArrayList<>();
    }


    public void add(Item item) {
        this.items.add(item);
    }


    public void updateQuality() {
        for (Item item : items) {

            if (("Aged Brie".equals(item.getName())) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                if (item.getQuality() < 50) {
                    incrementQuality(item);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                incrementQuality(item);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                incrementQuality(item);
                            }
                        }
                    }
                }
            } else {
                if (item.getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                        decrementQuality(item);
                    }
                }
            }

            if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            } else {
                decrementSellIn(item);
            }

            if (item.getSellIn() < 0) {
                if ("Aged Brie".equals(item.getName())) {
                    if (item.getQuality() < 50) {
                        incrementQuality(item);
                    }
                } else {
                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                        item.setQuality(0);
                    } else {
                        if (item.getQuality() > 0) {
                            if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                                continue;
                            }
                            decrementQuality(item);
                        }
                    }
                }
            }
        }
    }

    private void decrementSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private void decrementQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    private void incrementQuality(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

}