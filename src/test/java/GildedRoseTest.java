import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		GildedRose GR = new GildedRose();

		Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
		int originQuality = sulfuras.quality;
		System.out.println(originQuality);
		assertThat(sulfuras.quality).isEqualTo(originQuality);
	}

}
