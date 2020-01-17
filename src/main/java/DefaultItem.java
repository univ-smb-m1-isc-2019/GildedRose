public class DefaultItem extends ItemCreate {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void  doUpdateQuality() {

        if (quality > 0) {
            quality--;
        }
        sellIn--;

        if (sellIn < 0 && quality > 0) {
            quality--;
        }

    }}
