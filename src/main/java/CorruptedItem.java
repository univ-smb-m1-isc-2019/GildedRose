public class CorruptedItem {
    public Item item;
    public boolean isCorrupted;

    public CorruptedItem(Item item, boolean isCorrupted){
        this.item = item;
        this.isCorrupted= isCorrupted;
    }

    public Item getItem(){
        return this.item;
    }

    public boolean getIsCorrupted(){
        return this.isCorrupted;
    }

}
