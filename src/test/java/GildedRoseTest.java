import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;
import java.util.List;


public class GildedRoseTest {

    @Test
    public void sulfuras_should_keep_same_quality() {
        GildedRose inn = new GildedRose();
        UpdateQuality uq = new UpdateQuality();
        Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
        int originalQuality = sulfuras.quality;

        for (int i = 0; i < 10; i++) {
            uq.UpdateQuality(inn.getItemList());
            assertTrue(originalQuality == sulfuras.quality);
        }
    }

    @Test
    public void quality_never_to_negative() {
        GildedRose inn = new GildedRose();
        UpdateQuality uq = new UpdateQuality();
        List<ResetItem> tmpList = inn.getItemList();

        for (int i = 0; i < 100; i++) {
            uq.UpdateQuality(tmpList);
            tmpList.stream()
                    .forEach(
                            resetItem -> {
                                assertTrue(resetItem.getItem().getQuality() >= 0);
                            }
                    );
        }
    }

    @Test
    public void quality_never_more_than_50() {
        GildedRose inn = new GildedRose();
        UpdateQuality uq = new UpdateQuality();
        List<ResetItem> tmpList = inn.getItemList();

        for (int i = 0; i < 100; i++) {
            uq.UpdateQuality(tmpList);
            tmpList.stream()
                    .forEach(
                            resetItem -> {
                                if(!resetItem.getItem().getName().equals("Sulfuras, Hand of Ragnaros")){
                                    assertTrue(resetItem.getItem().getQuality() <= 50);
                                }

                            }
                    );
        }
    }


}
