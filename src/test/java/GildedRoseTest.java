import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {

	private static GildedRose gRoseTest;
	private static List<Item> items;
	private static List<Item> itemsExpectedResult;
	private static List<Item> items2;
	private static List<Item> itemsExpectedResult2;

	/** Initialization list of items **/
	public static void CreateItemList_1() {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	}


	/** Initialization list of expected items **/
	public static void CreateItemResultsList_1() {
		itemsExpectedResult = new ArrayList<Item>();
		itemsExpectedResult.add(new Item("+5 Dexterity Vest", 9, 19));
		itemsExpectedResult.add(new Item("Aged Brie", 1, 1));
		itemsExpectedResult.add(new Item("Elixir of the Mongoose", 4, 6));
		itemsExpectedResult.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		itemsExpectedResult.add(new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21));
	}

	/** Initialization list of items2 **/
	public static void CreateItemList_2() {
		items2 = new ArrayList<Item>();
		items2.add(new Item("+5 Dexterity Vest", 0, 20));
		items2.add(new Item("Aged Brie", 0, 0));
		items2.add(new Item("Elixir of the Mongoose", 0, 7));
		items2.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items2.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
	}


	/** Initialization list of expected items2 **/
	public static void CreateItemResultsList_2() {
		itemsExpectedResult2 = new ArrayList<Item>();
		itemsExpectedResult2.add(new Item("+5 Dexterity Vest", -1, 18));
		itemsExpectedResult2.add(new Item("Aged Brie", -1, 2));
		itemsExpectedResult2.add(new Item("Elixir of the Mongoose", -1, 5));
		itemsExpectedResult2.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		itemsExpectedResult2.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
	}



	@BeforeClass
	public static void runTest_1(){
		CreateItemList_1();
		CreateItemResultsList_1();
		gRoseTest = new GildedRose(items);
		gRoseTest.updateQuality();
	}

	@BeforeClass
	public static void runTest_2(){
		CreateItemList_2();
		CreateItemResultsList_2();
		gRoseTest = new GildedRose(items2);
		gRoseTest.updateQuality();
	}

	@Test
	public void testListsEquals_1(){
		System.out.println("List 1");
		for(int i = 0; i < items.size(); i++){
			updateQualityStandardItem(items.get(i),itemsExpectedResult.get(i));
			System.out.println(i + ": Item is OK");
		}
	}

	@Test
	public void testListsEquals_2(){
		System.out.println("\nList 2");
		for(int i = 0; i < items.size(); i++){
			updateQualityStandardItem(items2.get(i),itemsExpectedResult2.get(i));
			System.out.println(i + ": Item is OK");
		}
	}


	public void updateQualityStandardItem(Item item, Item itemResultExpected){
		Assert.assertEquals(itemResultExpected.getQuality(), item.getQuality());
		Assert.assertEquals(itemResultExpected.getSellIn(),item.getSellIn());
	}





}
