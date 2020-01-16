package gildedrose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

	@Test
	public void standardItemQualityShouldDecreaseByOneWhenSellInSuperiorThanZero(){
		int QUALITY_DECREASE_RATE = 1;

		GildedRose inn = new GildedRose();
		Item standardItem = inn.getItem("+5 Dexterity Vest");

		int qualityBeforeUpdate;
		while(standardItem.sellIn > 0){
			qualityBeforeUpdate = standardItem.quality;

			inn.updateQuality();
			assertThat(standardItem.quality).isEqualTo(qualityBeforeUpdate - QUALITY_DECREASE_RATE);
		}
	}

	@Test
	public void sulfurasQualityShouldNeverChange(){
		GildedRose inn = new GildedRose();

		Item sulfuras = inn.getItem("gildedrose.Sulfuras, Hand of Ragnaros");

		int originalQuality = sulfuras.quality;

		for(int i = 0; i < 100; ++i) {
			inn.updateQuality();
			assertThat(sulfuras.quality).isEqualTo(originalQuality);
		}
	}

	private static void reduceItemSellInValueTo(GildedRose inn, Item item, int sellIn){
		while(sellIn < item.sellIn){
			inn.updateQuality();
		}
	}
}
