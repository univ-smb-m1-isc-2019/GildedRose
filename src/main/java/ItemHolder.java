public class ItemHolder {
    private Item item;

    public ItemHolder(Item item) {

        this.item = item;
    }

    public void changeQualityOf(int n) {
        this.item.setQuality(this.item.getQuality() + n);
    }

    public void sellInPassed() {
        this.item.setSellIn(this.item.getSellIn() - 1);
    }

    public String getName() {
        return this.item.getName();
    }

    public void setName(String name) {
        this.item.setName(name);
    }

    public int getSellIn() {
        return this.item.getSellIn();
    }

    public void setSellIn(int sellIn) {
        this.item.setSellIn(sellIn);
    }

    public int getQuality() {
        return this.item.getQuality();
    }

    public void setQuality(int quality) {
        this.item.setQuality(quality);
    }

    public void updateQuality() {
        if ((!"Aged Brie".equals(this.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(this.getName())) {
            if (this.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(this.getName())) {
                    this.changeQualityOf(-1);
                }
            }
        } else {
            if (this.getQuality() < 50) {
                this.changeQualityOf(1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(this.getName())) {
                    if (this.getSellIn() < 11) {
                        if (this.getQuality() < 50) {
                            this.changeQualityOf(1);
                        }
                    }

                    if (this.getSellIn() < 6) {
                        if (this.getQuality() < 50) {
                            this.changeQualityOf(1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(this.getName())) {
            this.sellInPassed();
        }

        if (this.getSellIn() < 0) {
            if (!"Aged Brie".equals(this.getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(this.getName())) {
                    if (this.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(this.getName())) {
                            this.changeQualityOf(-1);
                        }
                    }
                } else {
                    this.changeQualityOf(this.getQuality());
                }
            } else {
                if (this.getQuality() < 50) {
                    this.changeQualityOf(1);
                }
            }
        }
    }

    public int getQualityToRemove() {
        return 0;
    }
}