package gildedrose;

import gildedrose.GildedRose;
import gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BackstagePassTest {

    @Test
    public void nonRegression() {
        GildedRose inn = new GildedRose();
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);

        inn.add(item);
        assertTrue(item.getQuality() == 20);
        assertTrue(item.getSellIn() == 15);

        inn.updateQuality();
        assertTrue(item.getQuality() == 21);
        assertTrue(item.getSellIn() == 14);

        inn.updateQuality();
        assertTrue(item.getQuality() == 22);
        assertTrue(item.getSellIn() == 13);

        inn.updateQuality();
        assertTrue(item.getQuality() == 23);
        assertTrue(item.getSellIn() == 12);

        inn.updateQuality();
        assertTrue(item.getQuality() == 24);
        assertTrue(item.getSellIn() == 11);

        inn.updateQuality();
        assertTrue(item.getQuality() == 25);
        assertTrue(item.getSellIn() == 10);

        inn.updateQuality();
        assertTrue(item.getQuality() == 27);
        assertTrue(item.getSellIn() == 9);

        inn.updateQuality();
        assertTrue(item.getQuality() == 29);
        assertTrue(item.getSellIn() == 8);

        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertTrue(item.getQuality() == 44);
        assertTrue(item.getSellIn() == 2);

        inn.updateQuality();
        assertTrue(item.getQuality() == 47);
        assertTrue(item.getSellIn() == 1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 50);
        assertTrue(item.getSellIn() == 0);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -1);

        inn.updateQuality();
        assertTrue(item.getQuality() == 0);
        assertTrue(item.getSellIn() == -2);

    }
}
