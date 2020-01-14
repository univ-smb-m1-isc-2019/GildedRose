import java.util.ArrayList;

public class ConditionQuality {
    String brie = "Aged Brie";
    String sulfuras = "Sulfuras, Hand of Ragnaros";
    String backstage = "Backstage passes to a TAFKAL80ETC concert";
    String conjured = "Conjured Mana Cake";
    ///////////////////////////////////////////////////////////////////
    public void decrease_quality(Item item){

        if ((!brie.equals(item.getName())) && (!backstage.equals(item.getName())))
        {
            if (item.getQuality() > 0 &&!sulfuras.equals(item.getName()) && !conjured.equals(item.getName()))
            {
                item.setQuality(item.getQuality() - 1);

            }
        }

        else
        {
            if (item.getQuality() < 50)
            {
                item.setQuality(item.getQuality() + 1);

                if (backstage.equals(item.getName()) && (item.getSellIn() < 11)&&(item.getQuality() < 50))
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
    public void decrease_sellIn(Item item){
        if (!sulfuras.equals(item.getName()))
        {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    ///////////////////////////////////////////////////////////////////
    public void decrease_quality_sellIn_wrong(Item item){

        if (item.getSellIn() < 0)
        {
            if (!brie.equals(item.getName()))
            {
                if (!backstage.equals(item.getName()))
                {
                    if (item.getQuality() > 0)
                    {
                        if (!sulfuras.equals(item.getName()) && !conjured.equals(item.getName()))
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
    public void decrease_quality_item_conjured(Item item){
        int qualityConjured = item.getQuality();
        //cas ou l'item conjuré a une date de vente positive ou egale a 0
        if (conjured.equals(item.getName()) && qualityConjured > 0 && item.getSellIn() >= 0 )
        {
            if (qualityConjured - 2 >= 0){
            item.setQuality(qualityConjured -2);
            }
        }
        //cas ou l'item conjuré a une date vente negative
        else if (conjured.equals(item.getName()) && qualityConjured > 0 && item.getSellIn() < 0)
        {
            if (qualityConjured - 4 >= 0){
            item.setQuality(qualityConjured -4);
            }
            else if(qualityConjured - 2 >= 0){
                item.setQuality(qualityConjured -2);
            }
            else if(qualityConjured - 1 >= 0){
                item.setQuality(qualityConjured -1);
            }
        }

    }
}
