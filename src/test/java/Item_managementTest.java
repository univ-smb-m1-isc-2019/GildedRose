import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Item_managementTest {
    private static Item_management item_mTest;
    private static Item legend_item;
    private static Item standardTestItem;

    @BeforeClass
    public static void runT(){
        item_mTest = new Item_management();
        legend_item = new Item("Sulfuras, Hand of Ragnaros",0, 80);
        standardTestItem = new Item("Aged Brie", 2, 1);
    }

    @Test
    public void isLegendaryItem() {
        Assert.assertTrue(item_mTest.isLegendaryItem(legend_item));
    }

    @Test
    public void itemQualityIncrement() {
        int qualityItem;

        /* For items with quality  > 50 */
        qualityItem = legend_item.getQuality() + 1;
        item_mTest.itemQualityIncrement(legend_item);
        Assert.assertNotEquals(legend_item.getQuality(), qualityItem);

        /* For items with quality < 50 */
        qualityItem = standardTestItem.getQuality() + 1;
        item_mTest.itemQualityIncrement(standardTestItem);
        Assert.assertEquals(standardTestItem.getQuality(), qualityItem);
    }

    @Test
    public void itemQualityDecrement() {
        int qualityItem;

        /* Legendary item */
        qualityItem = legend_item.getQuality();
        item_mTest.itemQualityDecrement(legend_item);
        Assert.assertEquals(legend_item.getQuality(), qualityItem);

        /* For items with quality > 0 and < 50  */
        qualityItem = standardTestItem.getQuality();
        item_mTest.itemQualityDecrement(standardTestItem);
        Assert.assertNotEquals(standardTestItem.getQuality(), qualityItem);

        /* For items with quality = 0 */
        qualityItem = 0;
        item_mTest.itemQualityDecrement(standardTestItem);
        Assert.assertEquals(standardTestItem.getQuality(), qualityItem);
    }

    @Test
    public void dayPassed() {
        int sellIn;

        /* Legendary item */
        sellIn = legend_item.getSellIn();
        item_mTest.dayPassed(legend_item);
        Assert.assertEquals(sellIn, legend_item.sellIn);

        /* Other items */
        sellIn = standardTestItem.getSellIn() - 1;
        item_mTest.dayPassed(standardTestItem);
        Assert.assertEquals(sellIn, standardTestItem.sellIn);

    }

    @Test
    public void qualityIncrementBackstage() {
        int qualityItem;
        Item itemForTest = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);

        /* For items with sellIn > 11 */
        qualityItem = itemForTest.getQuality();
        item_mTest.qualityIncrementBackstage(itemForTest);
        Assert.assertEquals(qualityItem, itemForTest.getQuality());

        /* Set sellIn of item to 10 */
        itemForTest.setSellIn(10);

        /* For items with sellIn < 11  and > 5 */
        qualityItem = itemForTest.getQuality() + 1;
        item_mTest.qualityIncrementBackstage(itemForTest);
        Assert.assertEquals(qualityItem, itemForTest.getQuality());

        /* Set sellIn of item to 5 */
        itemForTest.setSellIn(5);

        /* For items with sellIn < 6 */
        qualityItem = itemForTest.getQuality() + 2;
        item_mTest.qualityIncrementBackstage(itemForTest);
        Assert.assertEquals(qualityItem, itemForTest.getQuality());

    }
}