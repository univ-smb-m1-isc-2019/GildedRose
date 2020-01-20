import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

	@Test
	public void sulfuras_should_be_same_quality() {
		GildedRose GR = new GildedRose();

		Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
		int originQuality = sulfuras.quality;

		range(1,100).forEach(x ->{
			GR.udapteQuality();
			assertThat(sulfuras.quality).isEqualTo(originQuality);


		});
	}

    @Test
    public void sulfuras_cant_be_selled() {
        GildedRose GR = new GildedRose();
        Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
        int originSellIn = sulfuras.sellIn;
        for (int i = 0; i < 100; i++) {
            GR.udapteQuality();
            assertThat(sulfuras.sellIn).isEqualTo(originSellIn);
        }
    }

    @Test
	public void Quality_of_an_item_is_never_negative(){

		GildedRose GR = new GildedRose();
		List<AdvancedItem> maliste = GR.getItemList();

		for (int i =0; i < 100; i++) {

			GR.udapteQuality();
			maliste.stream()
					.forEach(item -> assertThat(item.getItem().getQuality()).isGreaterThan(-1) );

		}
	}

	@Test
	public void item_never_more_50quality(){

		GildedRose GR = new GildedRose();
		List<AdvancedItem> maliste = GR.getItemList();

        Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
        System.out.println(maliste);
		for (int i =0; i < 100; i++) {

			GR.udapteQuality();

			maliste.stream()
					.forEach(item -> {
					    if (item.equals(sulfuras)) {
							assertThat(item.getItem().getQuality()).isLessThan(51);
						}
					}
			);

		}
	}


    @Test
    public void brie_should_increase_of_quality() {
        GildedRose GR = new GildedRose();

        Item brie = GR.get("Aged Brie");
        int originQuality = brie.getQuality();
        for (int i = 0; i < 100; i++) {
            GR.udapteQuality();
            assertThat(originQuality).isLessThanOrEqualTo(brie.quality);
        }
    }

    @Test
    public void quality_degrade__twice_item_conjured() {
        GildedRose GR = new GildedRose();
        Item conjured = GR.get("Conjured Mana Cake");

        for (int i = 0; i < 100; i++) {
            int originQualityConjured = conjured.getQuality();
            GR.udapteQuality();


            int actualQualityConjured = conjured.getQuality();
            if (originQualityConjured - 2 >= 0 && conjured.getSellIn() >= 0) {
                assertThat(originQualityConjured - 2).isEqualTo(actualQualityConjured);
            }
            else if (originQualityConjured - 4 >= 0 && conjured.getSellIn() < 0) {
                assertThat(originQualityConjured - 4).isEqualTo(actualQualityConjured);
            }
        }
    }
    @Test
    public void backstage_should_increase_of_quality() {
        GildedRose GR = new GildedRose();

        Item backstage = GR.get("Backstage passes to a TAFKAL80ETC concert");

        for (int i = 0; i < 100; i++) {
            int originQualityBackstage = backstage.getQuality();
            GR.udapteQuality();

            int actualQualityBackstage = backstage.getQuality();
            int sellInBackstage = backstage.getSellIn();

            if(actualQualityBackstage < 50) {
                if (sellInBackstage < 10 && sellInBackstage >= 5) {
                    assertThat(originQualityBackstage + 2).isEqualTo(actualQualityBackstage);
                } else if (sellInBackstage < 5 && sellInBackstage >= 0) {
                    assertThat(originQualityBackstage + 3).isEqualTo(actualQualityBackstage);

                } else if (sellInBackstage < 0) {
                    assertThat(actualQualityBackstage).isEqualTo(0);
                } else {
                    assertThat(originQualityBackstage + 1).isEqualTo(actualQualityBackstage);
                }
            }

        }
    }
    @Test
    public void quality_degrade_twice_when_sell_passed() {
        GildedRose GR = new GildedRose();
        List<AdvancedItem> maliste = GR.getItemList();
        Item dexterity = GR.get("+5 Dexterity Vest");
        Item elixir = GR.get("Elixir of the Mongoose");
        Item conjured = GR.get("Conjured Mana Cake");

        for (int i = 0; i < 100; i++) {
            int originQualityDexterity = dexterity.getQuality();
            int originQualityElixir = elixir.getQuality();
            int originQualityConjured = conjured.getQuality();
            GR.udapteQuality();
            maliste.stream()
                    .forEach(
                            item -> {
                                if (item.equals(elixir)  && elixir.getSellIn() < 0 && elixir.getQuality() != 0) {
                                    assertThat(originQualityElixir - 2).isEqualTo(elixir.getQuality());
                                }
                                else if (item.equals(dexterity)  && dexterity.getSellIn() < 0 && dexterity.getQuality() != 0){
                                    assertThat(originQualityDexterity - 2).isEqualTo(dexterity.getQuality());
                                }
                                else if (item.equals(conjured)   && conjured.getSellIn() < 0 && originQualityConjured - 4 >= 0){
                                    assertThat(originQualityConjured - 4).isEqualTo(conjured.getQuality());
                                }
                            }
                    );

        }
    }

    @Test
    public void quality_degrade_standard_item() {
        GildedRose GR = new GildedRose();
        List<AdvancedItem> maliste = GR.getItemList();
        Item dexterity = GR.get("+5 Dexterity Vest");
        Item elixir = GR.get("Elixir of the Mongoose");


        for (int i = 0; i < 100; i++) {
            int originQualityDexterity = dexterity.getQuality();
            int originQualityElixir = elixir.getQuality();
            GR.udapteQuality();
            maliste.stream()
                    .forEach(
                            item -> {
                                if (item.equals(elixir) && elixir.getSellIn() >= 0 && elixir.getQuality() != 0) {
                                    assertThat(originQualityElixir - 1).isEqualTo(elixir.getQuality());
                                }
                                else if (item.equals(dexterity)  && dexterity.getSellIn() >= 0 && dexterity.getQuality() != 0){
                                    assertThat(originQualityDexterity - 1).isEqualTo(dexterity.getQuality());
                                }
                            }
                    );

        }
    }
}


