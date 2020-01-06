import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void sulfura_should_have_the_same_quality() {
	    GildedRose gildedRose = new GildedRose();
	    Item sulfura = gildedRose.get("Sulfuras, Hand of Ragnaros");
	    int quality = sulfura.getQuality();
	    gildedRose.updateQuality();
	    assertTrue(sulfura.getQuality() == quality);
	}
}
