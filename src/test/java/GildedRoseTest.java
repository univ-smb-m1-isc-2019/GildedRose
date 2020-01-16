import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class GildedRoseTest {
    public static int I_MAX = 100;

	@Test
	public void testTheTruth() {
		boolean test = true;
		assertTrue(test);
	}

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
        for(int i = 0; i< I_MAX;i++){
            GR.updateQuality();
            itemslist.stream()
                    .forEach(
                            item ->{
                                if(item.name != "Sulfuras, Hand of Ragnaros"){
                                    assertThat(item.getQuality()).isLessThanOrEqualTo(50);
                                }
                            }
                    );

        }
    }


}
