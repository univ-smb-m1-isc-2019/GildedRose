import java.util.List;

public class udapteQ {

    public udapteQ(AdvancedItem conjuredItem) {
        Item items =conjuredItem.getItem();
        int conjured =  conjuredItem.getConjured() ? 2 : 1 ;

        if ((!"Aged Brie".equals(items.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
        {
            if (items.getQuality() > 0)
            {
                if (!"Sulfuras, Hand of Ragnaros".equals(items.getName()))
                {
                    items.setQuality(items.getQuality() - conjured);
                }
            }
        }
        else
        {
            if (items.getQuality() < 50)
            {
                items.setQuality(items.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
                {
                    if (items.getSellIn() < 11)
                    {
                        if (items.getQuality() < 50)
                        {
                            items.setQuality(items.getQuality() + 1);
                        }
                    }

                    if (items.getSellIn() < 6)
                    {
                        if (items.getQuality() < 50)
                        {
                            items.setQuality(items.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(items.getName()))
        {
            items.setSellIn(items.getSellIn() - 1);
        }
    }
}
