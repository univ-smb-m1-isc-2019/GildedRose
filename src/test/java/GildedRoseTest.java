import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class GildedRoseTest {

	private static GildedRose gRoseTest;

	@BeforeClass
	public static void runTest(){
		CreateItemList listForTests = new CreateItemList();
		gRoseTest = new GildedRose(listForTests.getItems());
	}

	@Test
	public void updateQuality(){

	}





}
