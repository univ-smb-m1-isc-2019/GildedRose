import org.junit.Test;

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

}

