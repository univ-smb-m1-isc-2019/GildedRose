import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void qualityUnder50() {

		GildedRose gildedRose = new GildedRose();
		Item sulfuras = gildedRose.get("Sulfuras, Hand of Ragnaros");
		for (int i = 0; i < 100; i++) {
			gildedRose.updateGildedRose();
			gildedRose.getStorage().getListItems().stream()
					.forEach(item -> {
								if (item != sulfuras) {
									assertTrue(item.getQuality() < 51);
								}
							}
					);
		}
	}

	@Test
	public void QualityNeverNegative() {
		GildedRose gildedRose = new GildedRose();
		for (int i = 0; i < 100; i++) {
			gildedRose.updateGildedRose();
			gildedRose.getStorage().getListItems()
					.forEach(item ->
							assertTrue(item.getQuality() > -1));
		}
	}

	@Test
	public void increaseBrieQuality() {
		GildedRose gildedRose = new GildedRose();
		Item brie = gildedRose.get("Aged Brie");
		int originQuality = brie.getQuality();
		for (int i = 0; i < 100; i++) {
			gildedRose.updateGildedRose();
			assertTrue(originQuality <= brie.getQuality());
		}
	}

	@Test
	public void sulfurasNotSelled() {
		GildedRose gildedRose = new GildedRose();
		Item sulfuras = gildedRose.get("Sulfuras, Hand of Ragnaros");
		int originSellIn = sulfuras.sellIn;
		for (int i = 0; i < 100; i++) {
			gildedRose.updateGildedRose();
			assertEquals(originSellIn, sulfuras.sellIn);
		}
	}

	@Test
	public void sameSulfurasQuality() {
		GildedRose gildedRose = new GildedRose();
		Item sulfuras = gildedRose.get("Sulfuras, Hand of Ragnaros");
		int originQuality = sulfuras.quality;
		for (int i = 0; i < 100; i++) {
			gildedRose.updateGildedRose();
			assertEquals(originQuality, sulfuras.quality);
		}
	}
}
