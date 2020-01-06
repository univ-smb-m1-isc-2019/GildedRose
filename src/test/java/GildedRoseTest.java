import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	//Effectue un test permettant de savoir si l'item sulfuras reste bien le même que l'original
	@Test
	public void sulfuras_should_be_same_quality(){
		GildedRose GR = new GildedRose();
		GR.GildedRose();
		Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
		int originQuality = sulfuras.quality;
		for(int i=0; i<100; i++) {
			GR.updateQuality();
			assertTrue(originQuality == sulfuras.quality);
		}
	}


}
