import java.util.List;

public class UdapteQuality {
    public void UdapteQuality(List<AdvancedItem> itemList){

        for (AdvancedItem item : itemList) {
            modif(item);
        }
    }

    public void modif(AdvancedItem conjuredItem){
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
    public  void modif_sellin(AdvancedItem conjuredItem) {
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
