import java.util.ArrayList;
import java.util.List;

public class Treatment {
    public  void updateQuality(List<CorruptedItem> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            if ((!"Aged Brie".equals(items.get(i).getItem().getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getItem().getName()))
            {
                if (items.get(i).getItem().getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getItem().getName()))
                    {
                        if (items.get(i).getIsCorrupted()){
                            items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() - 2);
                        }
                        else{
                            items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() - 1);
                        }
                        if (items.get(i).getItem().getQuality() < 0 ){
                            items.get(i).getItem().setQuality(0);
                        }
                    }
                }
            }
            else
            {
                if (items.get(i).getItem().getQuality() < 50)
                {
                    items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getItem().getName()))
                    {
                        if (items.get(i).getItem().getSellIn() < 11)
                        {
                            if (items.get(i).getItem().getQuality() < 50)
                            {
                                items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() + 1);
                            }
                        }

                        if (items.get(i).getItem().getSellIn() < 6)
                        {
                            if (items.get(i).getItem().getQuality() < 50)
                            {
                                items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getItem().getName()))
            {
                items.get(i).getItem().setSellIn(items.get(i).getItem().getSellIn() - 1);
            }

            if (items.get(i).getItem().getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.get(i).getItem().getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getItem().getName()))
                    {
                        if (items.get(i).getItem().getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getItem().getName()))
                            {
                                if(items.get(i).getIsCorrupted()){
                                    items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() - 2);
                                }
                                else{
                                    items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() - 1);
                                }
                                if (items.get(i).getItem().getQuality() < 0 ){
                                    items.get(i).getItem().setQuality(0);
                                }
                            }
                        }
                    }
                    else
                    {
                        items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() - items.get(i).getItem().getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getItem().getQuality() < 50)
                    {
                        items.get(i).getItem().setQuality(items.get(i).getItem().getQuality() + 1);
                    }
                }
            }
        }
    }
}
