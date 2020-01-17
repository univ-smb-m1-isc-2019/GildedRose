public class DefaultItem extends ItemFactory {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void  doUpdateQuality() {

        if (quality > 0) {
            quality--;
        }
        sellIn--;

        if (sellIn < 0 && quality > 0) {
            quality--;
        }

    }}
