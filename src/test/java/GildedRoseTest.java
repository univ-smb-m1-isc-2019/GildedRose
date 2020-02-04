import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

	///////////////////////////////////////
	/*		Test de la qualité        */
	///////////////////////////////////////

	@Test
	public void quality_never_higher_50(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		for (int i = 0; i < 100; i++){
			gildedRose.updateQuality();
		}
		for (CorruptedItem item : gildedRose.getItems()){
			if (item.getItem().getName().equals("Sulfuras, Hand of Ragnaros")){
				sulfuras_should_have_same_quality();
			}
			else{
				assertThat(item.getItem().getQuality()).isLessThanOrEqualTo(50);
			}
		}
	}

	@Test
	public void quality_never_under_0(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		for (int i = 0; i < 10; i++){
			gildedRose.updateQuality();
		}
		for (CorruptedItem item : gildedRose.getItems()){
			assertThat(item.getItem().getQuality()).isGreaterThanOrEqualTo(0);
		}
	}

	///////////////////////////////////////
	/*		Test de sulfuras       */
	///////////////////////////////////////

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

	///////////////////////////////////////
	/*		Test de backstage      */
	///////////////////////////////////////

	@Test
	public void backstage_high_sellin(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem backstage = gildedRose.getItem("Backstage passes to a TAFKAL80ETC concert");
		int backstageQuality = backstage.getItem().getQuality();
		while (backstage.getItem().getSellIn() > 10){
			gildedRose.updateQuality();
			assertThat(backstage.getItem().getQuality()).isEqualTo(backstageQuality + 1);
			backstageQuality = backstage.getItem().getQuality();
		}

	}

	@Test
	public void backstage_mid_sellin(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem backstage = gildedRose.getItem("Backstage passes to a TAFKAL80ETC concert");
		int backstageQuality = backstage.getItem().getQuality();
		for(int i = 0; i < 100; i++){
			gildedRose.updateQuality();
			if (backstage.getItem().getSellIn() < 10 && backstage.getItem().getSellIn() > 5){
				assertThat(backstage.getItem().getQuality()).isEqualTo(backstageQuality + 2);
			}
			backstageQuality = backstage.getItem().getQuality();
		}

	}

	@Test
	public void backstage_low_sellin(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem backstage = gildedRose.getItem("Backstage passes to a TAFKAL80ETC concert");
		int backstageQuality = backstage.getItem().getQuality();
		for(int i = 0; i < 100; i++){
			gildedRose.updateQuality();
			if (backstage.getItem().getSellIn() < 5 && backstage.getItem().getSellIn() > 0){
				assertThat(backstage.getItem().getQuality()).isEqualTo(backstageQuality + 3);
			}
			backstageQuality = backstage.getItem().getQuality();
		}
	}

	@Test
	public void backstage_no_sellin() {
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem backstage = gildedRose.getItem("Backstage passes to a TAFKAL80ETC concert");
		int backstageQuality = backstage.getItem().getQuality();
		for (int i = 0; i < 100; ++i) {
			gildedRose.updateQuality();
			if (backstage.getItem().getSellIn() == 0) {
				gildedRose.updateQuality();
				assertThat(backstage.getItem().getQuality()).isEqualTo(0);
			}

		}
	}

	///////////////////////////////////////
	/*		Test de agedBrie      */
	///////////////////////////////////////

	@Test
	public void agedBrie__quality_plus_1() {
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem brie = gildedRose.getItem("Aged Brie");
		int brieQuality = brie.getItem().getQuality();
		while (brie.getItem().getSellIn() > 0){
			gildedRose.updateQuality();
			assertThat(brie.getItem().getQuality()).isEqualTo(brieQuality + 1);
			brieQuality = brie.getItem().getQuality();
		}
	}

	@Test
	public void agedBrie_quality_plus_2(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem brie = gildedRose.getItem("Aged Brie");
		int brieQuality = brie.getItem().getQuality();
		for(int i = 0; i < 100; i++){
			gildedRose.updateQuality();
			if (brie.getItem().getSellIn() < 0 && brie.getItem().getQuality() < 50){
				assertThat(brie.getItem().getQuality()).isEqualTo(brieQuality + 2);
			}
			brieQuality = brie.getItem().getQuality();
		}
	}

	///////////////////////////////////////
	/*		Test de conjured Mana Cake       */
	///////////////////////////////////////

	@Test
	public void conjured_quality_minus_2(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem cake = gildedRose.getItem("Conjured Mana Cake");
		int cakeQuality = cake.getItem().getQuality();
		for(int i = 0; i < 100; i++){
			gildedRose.updateQuality();
			if (cake.getItem().getSellIn() >= 0){
				assertThat(cake.getItem().getQuality()).isEqualTo(cakeQuality - 2);
			}
			cakeQuality = cake.getItem().getQuality();
		}
	}

	@Test
	public void conjured_qualtiy_minus_4(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem cake = gildedRose.getItem("Conjured Mana Cake");
		int cakeQuality = cake.getItem().getQuality();
		for(int i = 0; i < 100; i++){
			gildedRose.updateQuality();
			if (cake.getItem().getSellIn() < 0 && cake.getItem().getQuality() < 50 && cake.getItem().getQuality() > 50){
				assertThat(cake.getItem().getQuality()).isEqualTo(cakeQuality - 4);
			}
			cakeQuality = cake.getItem().getQuality();
		}
	}

	///////////////////////////////////////
	/*		Test des items      */
	///////////////////////////////////////

	@Test
	public void item_quality_minus_1(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem vest = gildedRose.getItem("+5 Dexterity Vest");
		CorruptedItem elixir = gildedRose.getItem("Elixir of the Mongoose");
		int vestQuality = vest.getItem().getQuality();
		int elixirQuality = elixir.getItem().getQuality();
		for (int i = 0; i < 30; i++) {
			gildedRose.updateQuality();
			if (vest.getItem().getSellIn() >= 0) { assertThat(vest.getItem().getQuality()).isEqualTo(vestQuality - 1 ); }
			if (elixir.getItem().getSellIn() >= 0)	{ assertThat(elixir.getItem().getQuality()).isEqualTo(elixirQuality - 1 ); }
			vestQuality = vest.getItem().getQuality();
			elixirQuality = elixir.getItem().getQuality();
		}
	}


	@Test
	public void item_quality_minus_2(){
		GildedRose gildedRose = new GildedRose();
		gildedRose.addAllItem();
		CorruptedItem vest = gildedRose.getItem("+5 Dexterity Vest");
		CorruptedItem elixir = gildedRose.getItem("Elixir of the Mongoose");
		int vestQuality = vest.getItem().getQuality();
		int elixirQuality = elixir.getItem().getQuality();
		for (int i = 0; i < 30; i++) {
			gildedRose.updateQuality();
			if (vest.getItem().getSellIn() < 0  && vest.getItem().getQuality() > 0) { assertThat(vest.getItem().getQuality()).isEqualTo(vestQuality - 2 ); }

			if (elixir.getItem().getSellIn() < 0 && elixir.getItem().getQuality() < 50 && elixir.getItem().getQuality() > 0)	{ assertThat(elixir.getItem().getQuality()).isEqualTo(elixirQuality - 2 ); }
			vestQuality = vest.getItem().getQuality();
			elixirQuality = elixir.getItem().getQuality();

		}
	}


}

