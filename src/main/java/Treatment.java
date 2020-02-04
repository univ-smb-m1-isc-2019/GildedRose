import java.util.ArrayList;
import java.util.List;

public class Treatment {
    public  void updateQuality(List<CorruptedItem> items){
        Item item;
        for (CorruptedItem Citem: items) {
            item = Citem.getItem();
            switch(item.getName())
            {
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.sellIn > 10) { item.setQuality(item.getQuality() + 1);}
                    if (item.sellIn <= 10 && item.sellIn > 5) { item.setQuality(item.getQuality() + 2);}
                    if (item.sellIn <= 5 && item.sellIn > 0) { item.setQuality(item.getQuality() + 3);}
                    if (item.sellIn == 0) { item.setQuality(0);}
                    break;
                case "Aged Brie":
                    if (item.sellIn > 0 && item.quality < 50) { item.setQuality(item.getQuality() + 1);}
                    if (item.sellIn <= 0 && item.quality < 50) { item.setQuality(item.getQuality() + 2);}
                    break;
                case "Conjured Mana Cake":
                    if (item.sellIn > 0 && isQualityGreaterThan1 (item)){ item.setQuality(item.getQuality() - 2);}
                    if (item.sellIn <= 0 && item.quality < 50 && isQualityGreaterThan3 (item)){ item.setQuality(item.getQuality() - 4);}
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    //rien a faire pour le moment
                    break;
                default:
                    if (item.sellIn > 0 && isQualityGreaterThan0( item)) {  item.setQuality(item.getQuality() -1);}
                    if (item.sellIn <= 0 && item.quality > 0 && isQualityGreaterThan1(item)) {  item.setQuality(item.getQuality() -2);}
            }
            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) { item.setSellIn(item.sellIn - 1); }
        }
    }

    private static boolean isQualityGreaterThan3(Item item) {
        return item.quality > 3;
    }

    private static boolean isQualityGreaterThan1(Item item) {
        return item.quality > 1;
    }

    private static boolean isQualityGreaterThan0(Item item) {
        return item.quality > 0;
    }

}

