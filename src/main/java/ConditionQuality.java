import java.util.ArrayList;

public class ConditionQuality {
    ///////////////////////////////////////////////////////////////////
    public static void decrease_quality(Item item){

        if ((!"Aged Brie".equals(item.getName())) && (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())))
        {
            if ((item.getQuality() > 0)&&(!"Sulfuras, Hand of Ragnaros".equals(item.getName())))
            {
                item.setQuality(item.getQuality() - 1);

            }
        }

        else
        {
            if (item.getQuality() < 50)
            {
                item.setQuality(item.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && (item.getSellIn() < 11)&&(item.getQuality() < 50))
                {
                    item.setQuality(item.getQuality() + 1);

                    if ((item.getSellIn() < 6) && (item.getQuality() < 50))
                    {
                        item.setQuality(item.getQuality() + 1);

                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////
    public static void decrease_sellIn(Item item){
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
        {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    ///////////////////////////////////////////////////////////////////
    public static void decrease_quality_sellIn_wrong(Item item){

        if (item.getSellIn() < 0)
        {
            if (!"Aged Brie".equals(item.getName()))
            {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                {
                    if (item.getQuality() > 0)
                    {
                        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                        {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                }
                else
                {
                    item.setQuality(item.getQuality() - item.getQuality());
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////
    public static void decrease_quality_item_conjured(Item item){
        if ("Conjured Mana Cake".equals(item.getName()))
        {
            item.setQuality(item.getQuality() -1);
        }
    }
}
