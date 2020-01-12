package gildedrose;

public class Item {

	/* Constants relating to quality and sellin */
	private static final int MAX_QUALITY = 50;
	protected static final int MIN_QUALITY = 0;
	private static final int SELL_PASSED = 0;

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item : " + this.name + "| Sell-in : " + this.sellIn + "| Quality : " + this.quality;
    }

	void decreaseSellIn() {
		sellIn = sellIn - 1;
	}

	private void increaseQuality(int rate) {
		quality = quality + (1 * rate);
	}

	void decreaseQuality(int rate) {
		quality = quality - (1 * rate);
	}

	private void setQualityToZero() {
		quality = 0;
	}

	void updateBackstagePass() {
		if (quality < MAX_QUALITY) {
			increaseQuality(1);

			if ((sellIn <= 10) && (quality < MAX_QUALITY)) {
				increaseQuality(2);
			}

			if ((sellIn <= 5) && (quality < MAX_QUALITY)) {
				increaseQuality(3);
			}
		}

		decreaseSellIn();

		if (sellIn < SELL_PASSED) {
			setQualityToZero();
		}
	}

	void updateAgedBrie() {
		decreaseSellIn();

		if (quality < MAX_QUALITY) {
			increaseQuality(1);
		}

		if (sellIn < SELL_PASSED && quality < MAX_QUALITY) {
			increaseQuality(1);
		}
	}

	void update() {
		decreaseSellIn();

		if (quality > MIN_QUALITY) {
			decreaseQuality(1);
		}

		if (sellIn < SELL_PASSED && quality > MIN_QUALITY ) {
			decreaseQuality(2);
		}
	}

}