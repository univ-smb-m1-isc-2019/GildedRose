import static java.util.stream.IntStream.range;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;



public class GildedRoseTest {

	@Test
	public void sulfurasQualityShouldNeverChange(){
		GildedRose inn = new GildedRose();

		Item sulfuras = inn.getItem("Sulfuras, Hand of Ragnaros");

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
