import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void sulfuras_should_have_same_quality() {
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem sulfuras = gildedRose.getItem("Sulfuras, Hand of Ragnaros");
		int sulfurasQuality = sulfuras.getItem().getQuality();
		for (int i = 0 ; i < 100; i ++) {
			gildedRose.updateQuality();
			assertTrue(sulfuras.getItem().getQuality() == sulfurasQuality);
		}

	}


}

