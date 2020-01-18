public abstract class ItemHolder {
    private Item item;

    public ItemHolder(Item item) {
        this.item = item;
    }

    public void changeQualityOf(int n) {
        this.item.setQuality(this.item.getQuality() + n);
    }

    public Item getItem() {
        return item;
    }
}
