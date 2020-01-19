public class ItemHolder implements ItemInterface {
    public static int MAXIMUM_QUALITY = 50;

    private Item item;

    public ItemHolder(Item item) {

        this.item = item;
    }

    @Override
    public void changeQualityOf(int n) {
        this.item.setQuality(this.item.getQuality() + n);

        if (this.getQuality() > this.getMaximumQuality())
            this.setQuality(this.getMaximumQuality());
        else if (this.getQuality() < 0)
            this.setQuality(0);
    }

    @Override
    public void sellInPassed() {
        this.setSellIn(this.item.getSellIn() - 1);
    }

    @Override
    public String getName() {
        return this.item.getName();
    }

    @Override
    public void setName(String name) {
        this.item.setName(name);
    }

    @Override
    public int getSellIn() {
        return this.item.getSellIn();
    }

    @Override
    public void setSellIn(int sellIn) {
        this.item.setSellIn(sellIn);
    }

    @Override
    public int getQuality() {
        return this.item.getQuality();
    }

    @Override
    public void setQuality(int quality) {
        this.item.setQuality(quality);
    }

    @Override
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

    @Override
    public int getQualityAmountToChange() {
        return 0;
    }

    @Override
    public int getMaximumQuality () {
        return MAXIMUM_QUALITY;
    }
}