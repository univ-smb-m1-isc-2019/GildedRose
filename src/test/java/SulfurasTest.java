import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SulfurasTest {

    @Test
    public void nonRegression() {
        GildedRose inn = new GildedRose();
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        inn.add(item);
        assertTrue(item.getQuality() == 80);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 80);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 80);
        assertTrue(item.getSellIn() == 0);

    }


}
