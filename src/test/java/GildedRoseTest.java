import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import java.util.Optional;


public class GildedRoseTest {

	@Test
	public void sulfura_should_keep_same_quality()
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
	@Test
	public void quality_should_be_more_than_50()
	{
		GildedRose gildedRose = new GildedRose();

		for(int i = 0; i<100; i++)
		{
			gildedRose.updateQuality();
		}

		Optional<Item> optional = gildedRose.getCommonItems().stream()
				.filter(item -> item.getQuality() > 50)
				.findFirst();

		assertTrue(optional.isEmpty());
	}

	@Test
	public void quality_should_never_be_less_than_0()
	{
		GildedRose gildedRose = new GildedRose();

		for(int i = 0; i<100; i++)
		{
			gildedRose.updateQuality();
		}

		Optional<Item> optional = gildedRose.getItems().stream()
				.filter(item -> item.getQuality() < 0)
				.findFirst();

		assertTrue(optional.isEmpty());
	}
}
