

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class GildedRoseTest {


    //Vérifie qu'un item standard pert bien un de valeur avant que sa date de vente soit inferieur a 0.
    @Test
    public void qualityDegradeNormally() {
        GildedRose gr = new GildedRose();
        List<Item> items = gr.getListItems();
        Item dexterity = gr.getItem("+5 Dexterity Vest");
        Item elixir = gr.getItem("Elixir of the Mongoose");

        for (int i = 0; i < 100; i++) {
            int lastQualityDexterity = dexterity.getQuality();
            int lastQualityElixir = elixir.getQuality();
            gr.updateQuality();

            items.stream()
                    .forEach(
                            item -> {
                                if (item == elixir && elixir.getSellIn() >= 0 && elixir.getQuality() != 0)
                                    assertThat(lastQualityElixir - 1).isEqualTo(elixir.getQuality());

                                else if (item == dexterity && dexterity.getSellIn() >= 0 && dexterity.getQuality() != 0)
                                    assertThat(lastQualityDexterity - 1).isEqualTo(dexterity.getQuality());
                            }
                    );
        }
    }


    //Vérifie qu'un item ne depasse jamais 50 de qualité.
    @Test
    public void qualityNeverOver50() {
        GildedRose gr = new GildedRose();
        List<Item> items = gr.getListItems();
        Item sulfuras = gr.getItem("Sulfuras, Hand of Ragnaros");
        for (int i = 0; i < 100; i++) {
            gr.updateQuality();
            items.stream()
                    .forEach(
                            item -> {
                                if (item != sulfuras) {
                                    assertThat(item.getQuality()).isLessThan(51);
                                }
                            }
                    );
        }
    }


    //Vérifie que la qualité d'un item n'est jamais inférieur à 0.
    @Test
    public void qualityNeverNegative() {
        GildedRose gr = new GildedRose();
        List<Item> items = gr.getListItems();
        for (int i = 0; i < 100; i++) {
            gr.updateQuality();
            items.stream()
                    .forEach(item ->
                            assertThat(item.getQuality()).isGreaterThan(-1)
                    );
        }
    }

    //Vérifie que la qualité de l'Aged Brie augmente avec son âge.
    @Test
    public void agedBrieQualityAugments() {
        GildedRose gr = new GildedRose();
        Item brie = gr.getItem("Aged Brie");
        int originQuality = brie.getQuality();
        for (int i = 0; i < 100; i++) {
            gr.updateQuality();
            assertThat(originQuality).isLessThanOrEqualTo(brie.quality);
        }
    }


    //Vérifie que la qualité du Backstage Pass prend de la valeur en approche de la sellIn date.
    @Test
    public void backstagePassQualityAugments() {
        GildedRose gr = new GildedRose();
        Item backstage = gr.getItem("Backstage passes to a TAFKAL80ETC concert");

        for (int i = 0; i < 100; i++) {
            int lastQualityBackstage = backstage.getQuality();
            gr.updateQuality();
            int actualQualityBackstage = backstage.getQuality();
            int sellInBackstage = backstage.getSellIn();

            if (actualQualityBackstage < 50) {
                if (sellInBackstage < 10 && sellInBackstage >= 5)
                    assertThat(lastQualityBackstage + 2).isEqualTo(actualQualityBackstage);

                else if (sellInBackstage < 5 && sellInBackstage >= 0)
                    assertThat(lastQualityBackstage + 3).isEqualTo(actualQualityBackstage);

                else if (sellInBackstage < 0)
                    assertThat(actualQualityBackstage).isEqualTo(0);

                else
                    assertThat(lastQualityBackstage + 1).isEqualTo(actualQualityBackstage);
            }
        }
    }

    //Vérifie que la qualité des ConjuredItem diminue deux fois plus rapidement qu'un NormalItem.
    @Test
    public void conjuredQualityDegradeTwiceAsFast() {
        GildedRose gr = new GildedRose();
        Item conjured = gr.getItem("Conjured Mana Cake");
        System.out.println(conjured.getQuality());
        gr.updateQuality();
        System.out.println(conjured.getQuality());
        for (int i = 0; i < 100; i++) {
            int lastQualityConjured = conjured.getQuality();
            gr.updateQuality();
            int actualQualityConjured = conjured.getQuality();

            if (lastQualityConjured - 2 >= 0 && conjured.getSellIn() >= 0)
                assertThat(lastQualityConjured - 2).isEqualTo(actualQualityConjured);

            else if (lastQualityConjured - 4 >= 0 && conjured.getSellIn() < 0)
                assertThat(lastQualityConjured - 4).isEqualTo(actualQualityConjured);
        }
    }

    //Vérifie qu'un item perd de sa valeur deux fois plus rapidement quand sa sellIn date est dépassée
    @Test
    public void qualityDegradeTwiceAsFastWhenSellinPassed() {
        GildedRose gr = new GildedRose();
        List<Item> items = gr.getListItems();

        Item conjured = gr.getItem("Conjured Mana Cake");
        Item elixir = gr.getItem("Elixir of the Mongoose");
        Item dVest = gr.getItem("+5 Dexterity Vest");

        for (int i = 0; i < 100; i++) {
            int lastQualityConjured = conjured.getQuality();
            int lastQualityElixir = elixir.getQuality();
            int lastQualityDVest = dVest.getQuality();
            gr.updateQuality();

            items.stream()
                    .forEach(
                            item -> {
                                if (item == conjured && conjured.getSellIn() < 0 && lastQualityConjured - 4 >= 0)
                                    assertThat(lastQualityConjured - 4).isEqualTo(conjured.getQuality());

                                else if (item == elixir && elixir.getSellIn() < 0 && elixir.getQuality() != 0)
                                    assertThat(lastQualityElixir - 2).isEqualTo(elixir.getQuality());

                                else if (item == dVest && dVest.getSellIn() < 0 && dVest.getQuality() != 0)
                                    assertThat(lastQualityDVest - 2).isEqualTo(dVest.getQuality());
                            }
                    );
        }
    }

    //Effectue un test permettant de savoir si la valeur de l'item sulfuras reste bien le même que l'original.
    @Test
    public void sulfurasQualityNeverChanges() {
        GildedRose gr = new GildedRose();
        Item sulfuras = gr.getItem("Sulfuras, Hand of Ragnaros");
        int originQuality = sulfuras.getQuality();
        for (int i = 0; i < 100; i++) {
            gr.updateQuality();
            assertTrue(originQuality == sulfuras.quality);
        }
    }

    //Vérifie que l'item sulfuras ne peut pas être vendu.
    @Test
    public void sulfurasCantBeSold() {
        GildedRose gr = new GildedRose();
        Item sulfuras = gr.getItem("Sulfuras, Hand of Ragnaros");
        int originSellIn = sulfuras.sellIn;
        for (int i = 0; i < 100; i++) {
            gr.updateQuality();
            assertTrue(originSellIn == sulfuras.sellIn);
        }
    }
}
