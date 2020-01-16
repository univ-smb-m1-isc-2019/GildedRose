import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {

	private static GildedRose gRoseTest;
	private static List<Item> items;
	private static List<Item> itemsExpectedResult;

	/** Initialization list of items **/
	public static void CreateItemList() {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	}


	/** Initialization list of expected items **/
	public static void CreateItemResultsList() {
		itemsExpectedResult = new ArrayList<Item>();
		itemsExpectedResult.add(new Item("+5 Dexterity Vest", 9, 19));
		itemsExpectedResult.add(new Item("Aged Brie", 1, 1));
		itemsExpectedResult.add(new Item("Elixir of the Mongoose", 4, 6));
		itemsExpectedResult.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		itemsExpectedResult.add(new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21));
	}

	@BeforeClass
	public static void runTest(){
		CreateItemList();
		CreateItemResultsList();
		gRoseTest = new GildedRose(items);
		gRoseTest.updateQuality();
	}

	@Test
	public void testListsEquals(){
		for(int i = 0; i < items.size(); i++){
			updateQualityStandardItem(items.get(i),itemsExpectedResult.get(i));
			System.out.println(i + ": Item is OK");
		}
	}


	public void updateQualityStandardItem(Item item, Item itemResultExpected){
		Assert.assertEquals(itemResultExpected.getQuality(), item.getQuality());
		Assert.assertEquals(itemResultExpected.getSellIn(),item.getSellIn());
	}





}
