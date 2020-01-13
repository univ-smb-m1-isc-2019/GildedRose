import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

    public GildedRose(){
        initialiseListItem();
    }

    private void initialiseListItem(){
        //System.out.println("OMGHAI!");
        items = new ArrayList<Item>();
        items.add(new RegularItem("+5 Dexterity Vest", 10, 20));
        items.add(new BetterWithTimeItem("Aged Brie", 2, 0));
        items.add(new RegularItem("Elixir of the Mongoose", 5, 7));
        items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new BetterNearSellInItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
    }

    public static void updateQuality(){
        for ( int i = 0; i <17; i++){
            for (Item item:items) {
                System.out.println(" Nom de l'item : "+item .getName()+"."+ " SellIn : "+item.getSellIn()+" Sa qualité : "+item.getQuality());
                item.updateQuality();
                System.out.println(" Nom de l'item : "+item .getName()+"."+ " SellIn : "+item.getSellIn()+" Sa qualité : "+item.getQuality());

            }
            System.out.println("----------------------------------------------------------------------------");
        }

    }
}