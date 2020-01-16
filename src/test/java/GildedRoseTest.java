

import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;


public class GildedRoseTest {

	@Test
	public void sulfuras_should_keep_same_quality()
	{
	    GildedRose gildedRose = new GildedRose();
	    Item sulfuras = gildedRose.get("Sulfuras, Hand of Ragnaros");
	    int quality = sulfuras.getQuality();
	    for(int i = 0; i<100; i++)
	    {
			gildedRose.updateQuality();
			//assertEquals(quality,sulfuras.getQuality());
			assertThat(sulfuras.getQuality()).isEqualTo(quality);
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
			//assertTrue(quality <= brie.getQuality());
			assertThat(quality).isLessThanOrEqualTo(brie.getQuality());

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

		Optional<MyItem> optional = gildedRose.getNonLegendaryItems().stream()
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

		Optional<MyItem> optional = gildedRose.getItems().stream()
				.filter(item -> item.getQuality() < 0)
				.findFirst();

		assertTrue(optional.isEmpty());
	}


	@Test
	public void sulfura_cannot_be_sold()
	{
		GildedRose gildedRose = new GildedRose();
		for(int i = 0; i<100; i++)
		{
			gildedRose.updateQuality();
		}

		Optional<MyItem> optional = gildedRose.getItems().stream()
				.filter(item -> item.getName().equals("Sulfuras, Hand of Ragnaros"))
				.findFirst();

		assertFalse(optional.isEmpty());
	}

	@Test
	public void item_with_date_passed_should_degrade_twice_as_fast()
	{
	}
}
