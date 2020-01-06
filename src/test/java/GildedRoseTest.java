import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {
    @Test

    public void sulfuras_should_keep_same_quality() {
        GildedRose inn = new GildedRose();
        Item sulfuras = inn.get("Sulfuras,  Hand of Ragnaros");

        int originQuality = sulfuras.quality;

        for (int i = 0; i < 100; i++) {
            inn.updateQuality();
            assertTrue(originQuality == sulfuras.quality);
        }
    }
}
