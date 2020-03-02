package gildedrose;

public class UpdateDependingOfType {
    public UpdateDependingOfType(Item item) {
        ItemType itemType = new ItemType(item);
        CustomItem itemToUpdate = null;

        switch(itemType.type) {
            case STANDARD:
                itemToUpdate = new StandardItem(item);
                break;
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
                break;
            default:
                break;
        }
        itemToUpdate.updateItemQuality();
    }

}
