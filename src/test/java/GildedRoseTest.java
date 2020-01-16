import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GildedRoseTest {

    @Test
    public void sulfuras_should_keep_same_quality(){
        GildedRose inn = new GildedRose();
        Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
        for (int i = 0; i < 100; i++){
            Item oldSulfuras = new Item(sulfuras.getName(), sulfuras.getSellIn(), sulfuras.getQuality());
            inn.updateQuality();
            assertThat(sulfuras.getQuality()).isEqualTo(oldSulfuras.getQuality());
        }
    }

    @Test
    public void sulfuras_never_has_to_be_sold(){
        GildedRose inn = new GildedRose();
        Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
        for (int i = 0; i < 100; i++){
            inn.updateQuality();
            assertThat(sulfuras.getSellIn()).isEqualTo(0);
        }
    }

	@Test
	public void quality_should_decrease(){
		GildedRose inn = new GildedRose();
        List<Item> standardItems = new ArrayList<>();
        standardItems.add(inn.get("+5 Dexterity Vest"));
        standardItems.add(inn.get("Elixir of the Mongoose"));
		for (int i = 0; i<100; i++){
            List<Item> oldList = inn.items
                    .stream()
                    .filter(el -> standardItems.contains(el))
                    .filter(el -> el.getQuality() > 0)
                    .map(el -> new Item(el.getName(), el.getSellIn(), el.getQuality()))
                    .collect(Collectors.toList());
            inn.updateQuality();
            oldList
                    .forEach(el -> {
                        assertThat(el.getQuality())
                                .isGreaterThan(inn.get(el.getName())
                                        .getQuality());
                    });
        }

	}

	@Test
	public void quality_above_0(){
		GildedRose inn = new GildedRose();
		for (int i = 0; i < 100; i++){
			inn.updateQuality();
			inn.items
                    .forEach(el ->
                            assertThat(el.getQuality()).isGreaterThanOrEqualTo(0)
                    );
		}
	}

    @Test
    public void quality_under_50(){
        GildedRose inn = new GildedRose();
        Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
        for (int i = 0; i < 100; i++){
            inn.updateQuality();
            inn.items
                    .stream()
                    .filter(el -> el != sulfuras)
                    .forEach(el ->
                            assertThat(el.getQuality()).isLessThanOrEqualTo(50)
                    );
        }
    }

    @Test
    public void aged_brie_quality_should_increase(){
        GildedRose inn = new GildedRose();
        Item brie = inn.get("Aged Brie");
        for (int i = 0; i < 100; i++){
            Item oldBrie = new Item(brie.getName(), brie.getSellIn(), brie.getQuality());
            inn.updateQuality();
            if (oldBrie.getSellIn() >= 0 && oldBrie.getQuality() + 1 < 50){
                assertThat(brie.getQuality()).isEqualTo(oldBrie.getQuality() + 1);
            }else if (oldBrie.getSellIn() < 0 && oldBrie.getQuality() + 2 < 50){
                assertThat(brie.getQuality()).isEqualTo(oldBrie.getQuality() + 2);
            }
        }
    }

    @Test
    public void quality_should_decrease_twice_after_date_passed(){
        GildedRose inn = new GildedRose();
        List<Item> standardItems = new ArrayList<>();
        standardItems.add(inn.get("+5 Dexterity Vest"));
        standardItems.add(inn.get("Elixir of the Mongoose"));
        for (int i = 0; i<100; i++){
            List<Item> oldList = inn.items
                    .stream()
                    .filter(el -> standardItems.contains(el))
                    .filter(el -> el.getSellIn() < 0)
                    .map(el -> new Item(el.getName(), el.getSellIn(), el.getQuality()))
                    .collect(Collectors.toList());
            inn.updateQuality();
            oldList
                    .forEach(el -> {
                        Item itemUpdated = inn.get(el.getName());
                        assertTrue(el.getQuality() - 2 == itemUpdated.getQuality()
                                || itemUpdated.getQuality() == 0);
                    });
        }
    }

    @Test
    public void backstage_passes_quality_should_increase(){
        GildedRose inn = new GildedRose();
        Item backstage = inn.get("Backstage passes to a TAFKAL80ETC concert");
        for (int i = 0; i < 100; i++){
            Item oldBackstage = new Item(backstage.getName(), backstage.getSellIn(), backstage.getQuality());
            inn.updateQuality();
            if(backstage.getQuality() < 50){
                if (oldBackstage.getSellIn() > 10){
                    assertEquals(oldBackstage.getQuality() + 1, backstage.getQuality());
                } else if (oldBackstage.getSellIn() > 5){
                    assertEquals(oldBackstage.getQuality() + 2, backstage.getQuality());
                }else if (oldBackstage.getSellIn() >= 0){
                    assertEquals(oldBackstage.getQuality() + 3, backstage.getQuality());
                }
            }

        }
    }

    @Test
    public void conjured_quality_should_decrease_twice(){
        GildedRose inn = new GildedRose();
        Item conjured = inn.get("Conjured Mana Cake");
        for (int i = 0; i < 100; i++){
            Item oldConjured = new Item(conjured.getName(), conjured.getSellIn(), conjured.getQuality());
            inn.updateQuality();

            if (oldConjured.getSellIn() < 0 && oldConjured.getQuality() - 4 >= 0){
                assertThat(conjured.getQuality()).isEqualTo(oldConjured.getQuality() - 4);
            }else if (oldConjured.getSellIn() >= 0 && oldConjured.getQuality() - 2 >= 0){
                assertThat(conjured.getQuality()).isEqualTo(oldConjured.getQuality() - 2);
            }

        }
    }
}
