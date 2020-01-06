

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Test
	public void sulfuras_should_keep_same_quality(){
		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
		int quality = sulfuras.getQuality();
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			assertThat(quality).isEqualTo(sulfuras.getQuality());
		}
	}

}
