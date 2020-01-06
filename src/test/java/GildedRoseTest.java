import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Optional;


public class GildedRoseTest {

	@Test
	public void sulfura_should_have_the_same_quality()
	{
	    GildedRose gildedRose = new GildedRose();
	    Item sulfura = gildedRose.get("Sulfuras, Hand of Ragnaros");
	    int quality = sulfura.getQuality();
	    for(int i = 0; i<100; i++)
	    {
			gildedRose.updateQuality();
			assertEquals(quality,sulfura.getQuality());
		}

	}

	@Test
	public void brie_should_increase_quality()
	{
		GildedRose gildedRose = new GildedRose();
		Item brie = gildedRose.get("Aged Brie");
		int quality = brie.getQuality();
		for(int i = 0; i<100; i++)
		{
			gildedRose.updateQuality();
			assertTrue(quality <= brie.getQuality());
		}
	}


}
