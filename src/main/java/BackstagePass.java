public class BackstagePass extends ItemCreate {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);

    }

    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality++;
            if (sellIn < 11) quality++;
            if (sellIn < 6) quality++;
        }
        sellIn--;
        if (sellIn < 0) quality = 0;
        item.setQuality(quality);
        item.setSellIn(sellIn);
    }

}
