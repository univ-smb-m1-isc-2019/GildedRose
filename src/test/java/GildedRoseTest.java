import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {
	GildedRose gr = new GildedRose();
	ArrayList<Item> items = gr.initItems();

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Test
	public void testLowerQuality() {
		ItemCreate normalItem=new ItemCreate("normal",10,20);
        items.add(normalItem);
		gr.updateQuality(items);
		assertEquals(19,normalItem.getQuality());
	}

	@Test
	public void lowerSellIn(){
		ItemCreate normalItem=new ItemCreate("normal",10,20);
		items.add(normalItem);
		gr.updateQuality(items);
		assertEquals(9,normalItem.getSellIn());
	}



	@Test
	public void gildedRoseTest() {
		gr.updateQuality(items);
	}
}
