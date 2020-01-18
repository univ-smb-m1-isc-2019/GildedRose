public class DefaultItem extends ItemCreate {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static void  doUpdateQuality(Item item) {
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality > 0) {
            quality--;

        }
        sellIn--;

        if (sellIn < 0 && quality > 0) {
           quality --;
        }
        item.setQuality(quality);
        item.setSellIn(sellIn);
    }}
