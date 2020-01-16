import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    /* Constants relating to Special Items names */
    private final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final static String ABRIE = "Aged Brie";
    private final static String BACKPASS = "Backstage passes to a TAFKAL80ETC concert";

    private List<Products> items;


    public GildedRose() {

        items = new ArrayList<Products>();
        items.add(new Products("+5 Dexterity Vest", 10, 20));
        items.add(new Products("Aged Brie", 2, 0));
        items.add(new Products("Elixir of the Mongoose", 5, 7));
        items.add(new Products("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Products("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Conjured("Conjured Mana Cake", 3, 6));

    }


    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {

            System.out.println("Before -> " + items.get(i).toString());


                /* Verifying if the current obj is the Brie */
                if (items.get(i).name.equals(ABRIE)) {
                    items.get(i).updateAgedBrie();
                    /* Verifying if the current obj is the Concert Pass */
                } else if (items.get(i).name.equals(BACKPASS)) {
                    items.get(i).updateBackstagePass();
                }

                /* Verifying if the current obj is a Normal Item */
                if (!items.get(i).name.equals(ABRIE) &&
                        !items.get(i).name.equals(BACKPASS) &&
                        !items.get(i).name.equals(SULFURAS)) {
                    items.get(i).update();
                }


            System.out.println("After -> " + items.get(i).toString());
        }
    }
}



