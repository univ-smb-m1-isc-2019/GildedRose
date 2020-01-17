public class DefaultItem extends ItemFactory {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void  doUpdateQuality() {

        if (quality < 50) {
            quality++;
        }
        sellIn--;

        if (sellIn < 0) {
            if (quality < 50) {
                quality++;
            }
        }

    }}
