import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
    private static List<SpecializedItem> specializedItems = null;
	//private static ItemToSpecializedItemParser itemParser;

    public GildedRose(){
        //On instanciation, initialise the item list and convert them to specialized items
        initialiseListItem();
        specializedItems = new ArrayList<SpecializedItem>();
        parseItems();
    }

    private void initialiseListItem(){
        //Create a list of items without distinctions.
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

    }
    //Update the quality of each specializedItem
    public static void updateQuality(){
       // for ( int i = 0; i <10; i++){
            for (SpecializedItem specializedItem:specializedItems) {
                System.out.println(" Nom de l'item : "+specializedItem .getName()+"."+ " SellIn : "+specializedItem.getSellIn()+" Sa qualité : "+specializedItem.getQuality());
                specializedItem.updateQuality();
                System.out.println(" Nom de l'item : "+specializedItem .getName()+"."+ " SellIn : "+specializedItem.getSellIn()+" Sa qualité : "+specializedItem.getQuality());

            }
            System.out.println("----------------------------------------------------------------------------");
       // }

    }
    //For each item, parse him into a specialized item, depending his name ( finaly, his behaviour )
    private void parseItems(){
        for (Item item:items) {
            specializedItems.add(ItemToSpecializedItemParser.itemToSpecializedItem(item));

        }
    }
}