package gildedrose;

import gildedrose.GildedRose;
import gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AgedBrieTest {

    @Test
    public void nonRegression() {
        GildedRose inn = new GildedRose();
        Item item = new Item("Aged Brie", 2, 0);

        inn.add(item);
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == 2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 1);
        assertTrue(item.getSellIn() == 1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 2);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 4);
        assertTrue(item.getSellIn() == -1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 6);
        assertTrue(item.getSellIn() == -2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 8);
        assertTrue(item.getSellIn() == -3);

        inn.updateQuality();
        assertTrue(item.getQuality() == 10);
        assertTrue(item.getSellIn() == -4);

        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertTrue(item.getQuality() == 48);
        assertTrue(item.getSellIn() == -23);

        inn.updateQuality();
        assertTrue(item.getQuality() == 50);
        assertTrue(item.getSellIn() == -24);

        inn.updateQuality();
        assertTrue(item.getQuality() == 50);
        assertTrue(item.getSellIn() == -25);

    }


}
