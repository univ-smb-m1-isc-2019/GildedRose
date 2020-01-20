public abstract class MeilleurItem {

    protected Item item;


    public MeilleurItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();


    public Item getItem() {
        return item;
    }
}


