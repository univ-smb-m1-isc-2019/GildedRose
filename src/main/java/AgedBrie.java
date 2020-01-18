public class AgedBrie extends ItemCreate {
    public AgedBrie( int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality++;
        }
        sellIn--;
        if (sellIn < 0 && quality < 50) {
                quality++;
            }
        item.setQuality(quality);
        item.setSellIn(sellIn);
        }

    }

