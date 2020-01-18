public abstract class ItemType {
    static final int LOWEST_QUALITY = 0;
    static final int HIGHEST_QUALITY = 50;
    public enum Type { STANDARD, CONJURED, LEGENDARY, CHEESE, TICKET };
    public String name;
    public int sellIn;
    public int quality;
    public Type type;

    public ItemType(Item item) {
        this.name = item.getName();
        this.sellIn = item.getSellIn();
        this.quality = item.getQuality();

        Type itemType;
        switch(this.name) {
            case "Conjured Mana Cake":
                itemType = Type.CONJURED;
                break;
            case "Sulfuras, Hand of Ragnaros":
                itemType = Type.LEGENDARY;
                break;
            case "Aged Brie":
                itemType = Type.CHEESE;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                itemType = Type.TICKET;
                break;
            case "Elixir of the Mongoose":
            case "+5 Dexterity Vest":
            default:
                itemType = Type.STANDARD;
        }
        this.type = itemType;
    }

    public abstract void updateItemQuality();

    protected boolean isQualityTooLow(){
        return quality < LOWEST_QUALITY;
    }

    protected boolean isQualityTooHigh(){
        return quality > HIGHEST_QUALITY;
    }

    protected void checkQualityInbounds(){
        if(isQualityTooLow()){
            quality = LOWEST_QUALITY;
        } else if(isQualityTooHigh())
            quality = HIGHEST_QUALITY;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
