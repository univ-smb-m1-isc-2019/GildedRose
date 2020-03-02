import gildedrose.GildedRose;
import gildedrose.Item;

public class Main {

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        GildedRose inn = new GildedRose();
        inn.add(new Item("+5 Dexterity Vest", 10, 20));
        inn.add(new Item("Aged Brie", 2, 0));
        inn.add(new Item("Elixir of the Mongoose", 5, 7));
        inn.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        inn.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        inn.add(new Item("Conjured Mana Cake", 3, 6));
        inn.updateQuality();

    }


}
