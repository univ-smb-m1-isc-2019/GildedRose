import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void sulfurasShouldKeepSameQuality() throws Exception {
		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");

		int originQuality = sulfuras.quality;

		for (int i = 0; i < 100; i++) {
			inn.updateQuality();
			assertEquals(originQuality, sulfuras.quality);
		}
	}

	@Test
	public void dexterityVestQualityShouldDecrementUntilZero() throws Exception {
		GildedRose inn = new GildedRose();
		Item dexterityVest = inn.get("+5 Dexterity Vest");

		int oldQuality;
		boolean hasNoQuality = false;

		for (int i = 0; i < 100; i++) {
			oldQuality = dexterityVest.quality;
			inn.updateQuality();

			if(dexterityVest.quality > 0 && dexterityVest.sellIn >= 0) {
				assertEquals(dexterityVest.quality, oldQuality - 1);
			}
			else if(dexterityVest.quality >= 0 && !hasNoQuality) {
				assertEquals(dexterityVest.quality, oldQuality - 2);
			}
			else {
				assertEquals(dexterityVest.quality, oldQuality);
			}

			hasNoQuality = dexterityVest.quality == 0;
		}
	}

	@Test
	public void elixirOfTheMongooseQualityShouldDecrementUntilZero() throws Exception {
		GildedRose inn = new GildedRose();
		Item elixirOfTheMongoose = inn.get("Elixir of the Mongoose");

		int oldQuality;
		boolean hasNoQuality = false;

		for (int i = 0; i < 100; i++) {
			oldQuality = elixirOfTheMongoose.quality;
			inn.updateQuality();

			if(elixirOfTheMongoose.quality > 0 && elixirOfTheMongoose.sellIn >= 0) {
				assertEquals(elixirOfTheMongoose.quality, oldQuality - 1);
			}
			else if(!hasNoQuality) {
				assertEquals(elixirOfTheMongoose.quality, oldQuality - 2);
			}
			else {
				assertEquals(elixirOfTheMongoose.quality, oldQuality);
			}

			hasNoQuality = elixirOfTheMongoose.quality == 0;
		}
	}

	@Test
	public void AgedBrieQualityShouldIncrement() throws Exception {
		GildedRose inn = new GildedRose();
		Item agedBrie = inn.get("Aged Brie");

		int oldQuality;
		boolean hasNoSellIn = false, hasReachMaxQuality = false;

		for (int i = 0; i < 100; i++) {
			oldQuality = agedBrie.quality;
			inn.updateQuality();

			if(hasReachMaxQuality) {
				assertEquals(agedBrie.quality, oldQuality);
			}
			else if(!hasNoSellIn) {
				assertEquals(agedBrie.quality, oldQuality + 1);
			}
			else {
				assertEquals(agedBrie.quality, oldQuality + 2);
			}

			hasNoSellIn = agedBrie.sellIn <= 0;
			hasReachMaxQuality = agedBrie.quality == 50;
		}
	}

	@Test
	public void BackstagePassesQualityShouldIncrement() throws Exception {
		GildedRose inn = new GildedRose();
		Item backstagePasses = inn.get("Backstage passes to a TAFKAL80ETC concert");

		int oldQuality;
		boolean hasReachMaxQuality = false;

		for (int i = 0; i < 100; i++) {
			oldQuality = backstagePasses.quality;
			inn.updateQuality();

			if(!hasReachMaxQuality && backstagePasses.sellIn >= 10) {
				assertEquals(backstagePasses.quality, oldQuality + 1);
			}
			else if(!hasReachMaxQuality && backstagePasses.sellIn >= 5) {
				assertEquals(backstagePasses.quality, oldQuality + 2);
			}
			else if(!hasReachMaxQuality) {
				assertEquals(backstagePasses.quality, oldQuality + 3);
			}
			else if(backstagePasses.sellIn >= 0) {
				assertEquals(backstagePasses.quality, oldQuality);
			}
			else {
				assertEquals(backstagePasses.quality, 0);
			}

			if(!hasReachMaxQuality) {
				hasReachMaxQuality = backstagePasses.quality == 50;
			}
		}
	}

}