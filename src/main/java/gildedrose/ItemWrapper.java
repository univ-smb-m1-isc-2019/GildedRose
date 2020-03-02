package gildedrose;

public class ItemWrapper {

    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
    }


    public int getQuality() {
        return item.getQuality();
    }

    public void setQuality(int quality) {
        item.setQuality(quality);
    }

    public boolean isBackstagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    public boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
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


    public void updateQuality() {

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
                if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                } else {
                    decrementQuality(item);
                }
            }
        }

        updateSellIn();

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
                        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                            return;
                        }
                        decrementQuality(item);
                    }
                }
            }
        }
    }

    protected void updateSellIn() {
        decrementSellIn(item);
    }

}
