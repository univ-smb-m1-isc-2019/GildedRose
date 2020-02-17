import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConjuredManaCakeTest {

    @Test
    public void nonRegression() {
        GildedRose inn = new GildedRose();
        Item item = new Item("Conjured Mana Cake", 3, 6);

        inn.add(item);
        assertTrue(item.getQuality() == 6);
        assertTrue(item.getSellIn() == 3);

        inn.updateQuality();
        assertTrue(item.getQuality() == 5);
        assertTrue(item.getSellIn() == 2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 4);
        assertTrue(item.getSellIn() == 1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 3);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 1);
        assertTrue(item.getSellIn() == -1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -3);

    }


}
