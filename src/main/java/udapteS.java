public class udapteS {
    public udapteS(AdvancedItem conjuredItem) {
        Item items =conjuredItem.getItem();
        int conjured =  conjuredItem.getConjured() ? 2 : 1 ;

        if (items.getSellIn() < 0)
        {
            if (!"Aged Brie".equals(items.getName()))
            {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.getName()))
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
                    items.setQuality(items.getQuality() - items.getQuality());
                }
            }
            else
            {
                if (items.getQuality() < 50)
                {
                    items.setQuality(items.getQuality() + 1);
                }
            }
        }
    }

}

