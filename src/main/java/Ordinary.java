public class Ordinary extends AbstractItem {
    @Override
    public void update() {
        if(dexterityVest.quality > 0 && dexterityVest.sellIn >= 0) {
            assertEquals(dexterityVest.quality, oldQuality - 1);
        }
        else if(dexterityVest.quality >= 0 && !hasNoQuality) {
            assertEquals(dexterityVest.quality, oldQuality - 2);
        }
        else {
            assertEquals(dexterityVest.quality, oldQuality);
        }

        hasNoQuality = dexterityVest.quality == 0;
    }
}
