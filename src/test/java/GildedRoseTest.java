import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


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
                                if (!resetItem.getItem().getName().equals("Sulfuras, Hand of Ragnaros")) {
                                    assertTrue(resetItem.getItem().getQuality() <= 50);
                                }

                            }
                    );
        }
    }

    @Test
    public void Aged_Brie_quality_increase(){
        GildedRose inn = new GildedRose();
        UpdateQuality uq = new UpdateQuality();
        List<ResetItem> tmpList = inn.getItemList();

        AtomicInteger quality = new AtomicInteger();

        for(int i=0;i<100;i++){
            tmpList
                    .forEach(
                            resetItem -> {
                                if(resetItem.getItem().getName().equals("Aged Brie")){
                                    quality.set(resetItem.getItem().quality);
                                }
                            }
                    );
            uq.UpdateQuality(tmpList);
            tmpList
                    .forEach(
                            resetItem -> {
                                if(resetItem.getItem().name == "Aged Brie" && resetItem.getItem().quality < 50){
                                    assertTrue(resetItem.getItem().getQuality() > quality.get());
                                }
                            }
                    );
        }
    }



}
