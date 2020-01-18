import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GildedRoseTest {

	@Test
	public void ItemTypeHasRightType() {
		List<Item> items = GildedRose.itemsInit();

		for (int i = 0; i < items.size(); i++){
			ItemType item = new ItemType(items.get(i));

			switch(items.get(i).getName()) {
				case "Conjured Mana Cake":
					assertSame(item.type, ItemType.Type.CONJURED);
					break;
				case "Sulfuras, Hand of Ragnaros":
					assertSame(item.type, ItemType.Type.LEGENDARY);
					break;
				case "Aged Brie":
					assertSame(item.type, ItemType.Type.CHEESE);
					break;
				case "Backstage passes to a TAFKAL80ETC concert":
					assertSame(item.type, ItemType.Type.TICKET);
					break;
				case "Elixir of the Mongoose":
				case "+5 Dexterity Vest":
				default:
					assertSame(item.type, ItemType.Type.STANDARD);
			}
		}
	}

    @Test
	public void QualityIsNeverNegative(){
        List<Item> items = GildedRose.itemsInit();

        for (int j = 0; j < 1000; j++){
            for (int i = 0; i < items.size(); i++)
            {
                GildedRose.updateQuality();
                assertTrue(items.get(i).quality >= 0);
            }
        }
    }

    @Test
    public void QualityIsNeverTooHigh(){
        List<Item> items = GildedRose.itemsInit();

        for (int j = 0; j < 1000; j++){
            for (int i = 0; i < items.size(); i++)
            {
                GildedRose.updateQuality();
                if(items.get(i).name == "Sulfuras, Hand of Ragnaros"){
                    assertTrue(items.get(i).quality == 80);
                } else {
                    assertTrue(items.get(i).quality <= 50);
                }
            }
        }
    }

}
