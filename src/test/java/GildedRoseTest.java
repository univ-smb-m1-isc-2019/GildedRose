import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertFalse;


public class GildedRoseTest {

	@Test
	public void sulfuras_should_keep_same_quality(){
		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
		int originalQuality = sulfuras.getQuality();
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			assertThat(originalQuality).isEqualTo(sulfuras.getQuality());
		}
	}

	@Test
	public void quality_above_0(){
		GildedRose inn = new GildedRose();
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			Optional<Item> optional = inn.items
					.stream()
					.filter(el -> el.getQuality() < 0)
					.findFirst();
			assertFalse(optional.isPresent());
		}
	}

	@Test
	public void quality_under_value(){
		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			Optional<Item> optional = inn.items
					.stream()
					.filter(el ->
						(el != sulfuras) && (el.getQuality() > 50))
					.findFirst();
			assertFalse(optional.isPresent());
		}
	}

	@Test
	public void quality_of_sulfuras_under_80(){
		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
		int originalQuality = sulfuras.getQuality();
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			assertThat(inn.get("Sulfuras, Hand of Ragnaros").getQuality()).isEqualTo(originalQuality);
		}
	}


}
