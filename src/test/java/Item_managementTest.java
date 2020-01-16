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
        standardTestItem = new Item("Aged Brie", 2, 0);
    }

    @Test
    public void isLegendaryItem() {
        Assert.assertTrue(item_mTest.isLegendaryItem(legend_item));
    }

    @Test
    public void itemQualityIncrement() {
        int qualityItem;

        /* Quality of item > 50 */
        qualityItem = legend_item.getQuality() + 1;
        item_mTest.itemQualityIncrement(legend_item);
        Assert.assertNotEquals(legend_item.getQuality(), qualityItem);

        /* Quality of item < 50 */
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

        /* Quality of item > 0 and < 50  */
        standardTestItem.setQuality(standardTestItem.getQuality() + 1);
        qualityItem = standardTestItem.getQuality();
        item_mTest.itemQualityDecrement(standardTestItem);
        Assert.assertNotEquals(standardTestItem.getQuality(), qualityItem);

        /* Quality of item = 0 */
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

        /* Other item */
        sellIn = standardTestItem.getSellIn() - 1;
        item_mTest.dayPassed(standardTestItem);
        Assert.assertEquals(sellIn, standardTestItem.sellIn);

    }

    @Test
    public void qualityIncrementBackstage() {
    }
}