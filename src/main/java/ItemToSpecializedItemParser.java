
public abstract class ItemToSpecializedItemParser {
    //This class is a parser, it does not need to be instancied.
    public ItemToSpecializedItemParser() {
    }
    //Take an item as argument and return an other kind of SpecializedItem, depending the name of the item.
    public static SpecializedItem itemToSpecializedItem(Item item){
        if(item.getName().equals("Sulfuras, Hand of Ragnaros")){
            return new LegendaryItem(item.getName(),item.getSellIn(),item.getQuality());
        }
        if(item.getName().equals("Aged Brie")){
            return new BetterWithTimeItem(item.getName(),item.getSellIn(),item.getQuality());
        }
        if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")){
            return new BetterNearSellInItem(item.getName(),item.getSellIn(),item.getQuality());
        }
        if(item.getName().equals("Conjured Mana Cake")){
            return new ConjuredItem(item.getName(),item.getSellIn(),item.getQuality());
        }
        else{
            return new RegularItem(item.getName(), item.getSellIn(), item.getQuality());
        }
    }
}