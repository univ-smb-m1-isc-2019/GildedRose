public class ConjuredItem extends ItemCreate {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality); }


    //
    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality -= 2;
        }
        sellIn--;
        if (sellIn < 0 && quality < 50) {
            quality -= 4;
        }
        item.setSellIn(sellIn);
        item.setQuality(quality);

    }

}
