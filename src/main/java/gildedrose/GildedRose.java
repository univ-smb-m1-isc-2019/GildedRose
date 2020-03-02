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
        items.forEach(this::updateQuality);
    }

    private void updateQuality(Item item) {

        if ((isAgedBrie(item)) || isBackstagePass(item)) {
            if (item.getQuality() < 50) {
                incrementQuality(item);

                if (isBackstagePass(item)) {
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
                if (isSulfuras(item)) {
                } else {
                    decrementQuality(item);
                }
            }
        }

        if (isSulfuras(item)) {
        } else {
            decrementSellIn(item);
        }

        if (item.getSellIn() < 0) {
            if (isAgedBrie(item)) {
                if (item.getQuality() < 50) {
                    incrementQuality(item);
                }
            } else {
                if (isBackstagePass(item)) {
                    item.setQuality(0);
                } else {
                    if (item.getQuality() > 0) {
                        if (isSulfuras(item)) {
                            return;
                        }
                        decrementQuality(item);
                    }
                }
            }
        }
    }

    private boolean isBackstagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
    }

    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
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