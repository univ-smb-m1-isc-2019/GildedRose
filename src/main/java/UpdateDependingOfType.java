public class UpdateDependingOfType {
    //private ItemType updatedItem;

    public UpdateDependingOfType(Item item) {
        int sellIn = item.sellIn;
        int quality = item.quality;
        ItemType itemType = new ItemType(item);
        CustomItem itemToUpdate = null;


        switch(itemType.type) {
            case STANDARD:
                itemToUpdate = new StandardItem(item);
                break;
            case CONJURED:
                if(sellIn > 0){
                    sellIn--;
                    if(quality > 0) quality -= 2;
                }else if (quality > 0) quality -= 4;
                break;
            case LEGENDARY:
                break;
            case CHEESE:
                if(sellIn > 0){
                    sellIn--;
                    if(quality < 50) quality++;
                }else if (quality < 50) quality += 2;
                break;
            case TICKET:
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
                break;
            default:
                break;
        }
        itemToUpdate.updateItemQuality();
    }

}
