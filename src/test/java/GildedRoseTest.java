import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class GildedRoseTest {
    public static int I_MAX = 100;

    @Test
    public void quality_never_negative() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        for (int i = 0; i < I_MAX; i++) {
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item -> {
                                assertThat(item.getQuality()).isGreaterThanOrEqualTo(0);
                            }
                    );
        }
    }

    @Test
    public void sulfuras_quality_never_decrease() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        for (int i = 0; i < I_MAX; i++) {
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item -> {
                                if (item.name == "Sulfuras, Hand of Ragnaros") {
                                    assertThat(item.getQuality()).isEqualTo(80);
                                }
                            }
                    );
        }
    }

    @Test
    public void sulfuras_cant_be_selled() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        for (int i = 0; i < I_MAX; i++) {
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item -> {
                                if (item.name == "Sulfuras, Hand of Ragnaros") {
                                    assertThat(item.getSellIn()).isGreaterThanOrEqualTo(0);
                                }
                            }
                    );
        }
    }

    @Test
    public void items_never_more_50_quality() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        for (int i = 0; i < I_MAX; i++) {
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item -> {
                                if (item.name != "Sulfuras, Hand of Ragnaros") {
                                    assertThat(item.getQuality()).isLessThanOrEqualTo(50);
                                }
                            }
                    );

        }
    }

  /*  @Test
    public void sell_date_passed_quality_twice_decrease() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        AtomicInteger vestquality = new AtomicInteger();
        AtomicInteger elixirquality = new AtomicInteger();
        AtomicInteger ccakequality = new AtomicInteger();
        for (int i = 0; i < I_MAX; i++) {
            itemslist
                    .forEach(
                            item -> {
                                if (item.name == "+5 Dexterity Vest")
                                    vestquality.set(item.quality);
                                else if (item.name == "Elixir of the Mongoose")
                                    elixirquality.set(item.quality);
                                else if (item.name == "Conjured Mana Cake")
                                    ccakequality.set(item.quality);
                                else {
                                }
                            }
                    );
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item -> {
                                if (item.sellIn < 0 && item.name == "+5 Dexterity Vest" && item.quality != 0)
                                    assertThat(item.quality - 2).isEqualTo(vestquality.get());

                                else if (item.sellIn < 0 && item.name == "Elixir of the Mongoose" && item.quality != 0)
                                    assertThat(item.quality - 2).isEqualTo(elixirquality.get());
                                else if (item.sellIn < 0 && item.name == "Conjured Mana Cake" && item.quality != 0)
                                    assertThat(item.quality - 2).isEqualTo(ccakequality.get());

                            }
                    );

        }
    }*/

    @Test
    public void brie_quality_increase() throws NoSuchFieldException, IllegalAccessException {
        GildedRose GR = new GildedRose();
        Field field = GR.getClass().getDeclaredField("items");
        field.setAccessible(true);
        ArrayList<Products> itemslist = (ArrayList<Products>) field.get(GR);
        AtomicInteger quality = new AtomicInteger();
        for (int i = 0; i < I_MAX; i++) {
            itemslist
                    .forEach(
                            item -> {
                                if (item.name == "Aged Brie") {
                                    quality.set(item.quality);
                                }
                            }
                    );
            GR.updateQuality();
            itemslist
                    .forEach(
                            item -> {
                                if (item.name == "Aged Brie" && item.quality < 50) {
                                    assertThat(item.getQuality()).isGreaterThan(quality.get());
                                }
                            }
                    );
        }
    }
}
