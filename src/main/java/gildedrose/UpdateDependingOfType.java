package gildedrose;

public class UpdateDependingOfType {
    public UpdateDependingOfType(Item item) {
        ItemType itemType = new ItemType(item);
        CustomItem itemToUpdate = null;

        switch(itemType.type) {
            case STANDARD:
                itemToUpdate = new StandardItem(item);
                break;

            case ItemType.Type.CONJURED:
                if(sellIn > 0){
                    sellIn--;
                    if(quality > 0) quality -= 2;
                }else if (quality > 0) quality -= 4;
                break;
            case ItemType.Type.LEGENDARY:
                break;
            case ItemType.Type.CHEESE:
                if(sellIn > 0){
                    sellIn--;
                    if(quality < 50) quality++;
                }else if (quality < 50) quality += 2;
                break;
            case ItemType.Type.TICKET:
                if(sellIn > 10){
                    sellIn--;
                    if(quality < 50) quality++;
                }else if (sellIn <= 10 && sellIn > 5){
                    sellIn--;
                    if(quality < 50) quality += 2;
                    quality += 2;
                }else if (sellIn <= 5 && sellIn > 0) {
                    sellIn--;
                    if (quality < 50) quality += 3;
                }else{
                    quality = 0;
                }
=======
            case CONJURED:
                itemToUpdate = new ConjuredItem(item);
                break;
            case LEGENDARY:
                itemToUpdate = new LegendaryItem(item);
                break;
            case CHEESE:
                itemToUpdate = new CheeseItem(item);
                break;
            case TICKET:
                itemToUpdate = new TicketItem(item);
>>>>>>> Added QualityIsNeverNegative test:src/main/java/UpdateDependingOfType.java
                break;
            default:
                break;
        }
        itemToUpdate.updateItemQuality();
    }

}
