
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


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

	//Permet de verifier que l'item sulfuras ne peut pas être vendu
	@Test
	public void sulfuras_cant_be_selled(){
		GildedRose GR = new GildedRose();
		GR.GildedRose();
		Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
		int originQuality = sulfuras.sellIn;
		for(int i=0; i<100; i++) {
			GR.updateQuality();
			assertTrue(originQuality == sulfuras.sellIn);
		}
	}

	//Effectue un test permettant qu'un item ne depasse jamais 50 de qualité
	@Test
	public void item_never_more_50quality(){

		GildedRose GR = new GildedRose();
		ArrayList<Item> items = GR.getItemList();
		Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");


		for (int i =0; i < 100; i++) {
			GR.updateQuality();
			items.stream()
					.forEach(
							item -> {
								if(item != sulfuras){
									assertThat(item.getQuality()).isLessThan(51);
								}
							}
								);

		}
	}



		//Effectue un test permettant de verifier que la qualité d'un item n'est jamais inférieur a 0
		@Test
		public void Quality_of_an_item_is_never_negative(){

			GildedRose GR = new GildedRose();
			GR.GildedRose();
			ArrayList<Item> items = GR.getItemList();

			for (int i =0; i < 100; i++) {

				GR.updateQuality();
				items.stream()
						.forEach(item ->
								assertThat(item.getQuality()).isGreaterThan(-1)
						);

			}
	}
	//Permet de verfier que la qualité de l'item Brie augmente avec son age
	@Test
	public void brie_should_increase_of_quality()
	{
		GildedRose GR = new GildedRose();
		GR.GildedRose();
		Item brie = GR.get("Aged Brie");
		int originQuality = brie.getQuality();
		for(int i = 0; i<100; i++)
		{
			GR.updateQuality();
			assertThat(originQuality).isLessThanOrEqualTo(brie.getQuality());
		}
	}


}
