import gildedrose.GildedRose;
import gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DexterityVestTest {

    @Test
    public void nonRegression() {
        GildedRose inn = new GildedRose();
        Item item = new Item("+5 Dexterity Vest", 10, 20);

        inn.add(item);
        assertTrue(item.getQuality() == 20);
        assertTrue(item.getSellIn() == 10);

        inn.updateQuality();
        assertTrue(item.getQuality() == 19);
        assertTrue(item.getSellIn() == 9);

        inn.updateQuality();
        assertTrue(item.getQuality() == 18);
        assertTrue(item.getSellIn() == 8);

        inn.updateQuality();
        assertTrue(item.getQuality() == 17);
        assertTrue(item.getSellIn() == 7);

        inn.updateQuality();
        assertTrue(item.getQuality() == 16);
        assertTrue(item.getSellIn() == 6);

        inn.updateQuality();
        assertTrue(item.getQuality() == 15);
        assertTrue(item.getSellIn() == 5);

        inn.updateQuality();
        assertTrue(item.getQuality() == 14);
        assertTrue(item.getSellIn() == 4);

        inn.updateQuality();
        assertTrue(item.getQuality() == 13);
        assertTrue(item.getSellIn() == 3);

        inn.updateQuality();
        assertTrue(item.getQuality() == 12);
        assertTrue(item.getSellIn() == 2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 11);
        assertTrue(item.getSellIn() == 1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 10);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 8);
        assertTrue(item.getSellIn() == -1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 6);
        assertTrue(item.getSellIn() == -2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 4);
        assertTrue(item.getSellIn() == -3);

        inn.updateQuality();
        assertTrue(item.getQuality() == 2);
        assertTrue(item.getSellIn() == -4);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -5);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -6);
    }


}
