public class ItemType {

    private String name;

    public ItemType (Item item){
        this.name=item.getName();
    }

    public MeilleurItem setType(Item item){
        if (name.contains("Sulfuras")) return new Sulfuras(item);
        else if (name.contains("Aged")) return new AgedBrie(item);
        else if (name.contains("Conjured")) return new ConjuredItem(item);
        else if (name.contains("Backstage")) return new BackstagePasses(item);
        else return new NormalItem(item);
    }
}
