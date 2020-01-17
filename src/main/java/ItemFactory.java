public class ItemFactory extends Item {

    public String name;
    public int sellIn;
    public int quality;

    public ItemFactory(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    };

    public static Item createItem(String name,int sellIn, int quality){

        switch (name) {
            case "Aged Brie":
                return new AgedBrie( sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass( sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras( sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }

        }

    protected void doUpdateQuality() {};
}



