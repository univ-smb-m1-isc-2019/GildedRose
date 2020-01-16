public class UpdateQuality {
    private ItemUpdate
            standardItemUpdate,
            conjuredItemUpdate,
            agedBrieUpdate,
            backstageUpdater,
            legendaryItemUpdate;

    public UpdateQuality(){
        standardItemUpdate = new StandardItemUpdate();
        agedBrieUpdate = new AgedBrieUpdate();
        backstageUpdater = new BackstageUpdate();
        conjuredItemUpdate = new ConjuredItemUpdate();
        legendaryItemUpdate = new LegendaryItemUpdate();
    }

    public void updateItem(Item item){
        if (item.getName().equals("+5 Dexterity Vest"))
            standardItemUpdate.updateQuality(item);
        else if (item.getName().equals("Elixir of the Mongoose"))
            standardItemUpdate.updateQuality(item);
        else if (item.getName().equals("Aged Brie"))
            agedBrieUpdate.updateQuality(item);
        else if (item.getName().equals("Sulfuras, Hand of Ragnaros"))
            legendaryItemUpdate.updateQuality(item);
        else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
            backstageUpdater.updateQuality(item);
        else if (item.getName().equals("Conjured Mana Cake"))
            conjuredItemUpdate.updateQuality(item);

    }
}
