package gildedrose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {
	
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
}
