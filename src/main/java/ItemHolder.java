public class ItemHolder {
    private Item item;

    public ItemHolder(Item item) {

        this.item = item;
    }

    public void changeQualityOf(int n) {
        this.item.setQuality(this.item.getQuality() + n);
    }

    public void sellInPassed() {
        this.item.setSellIn(this.item.getSellIn() - 1);
    }

    public String getName() {
        return this.item.getName();
    }

    public void setName(String name) {
        this.item.setName(name);
    }

    public int getSellIn() {
        return this.item.getSellIn();
    }

    public void setSellIn(int sellIn) {
        this.item.setSellIn(sellIn);
    }

    public int getQuality() {
        return this.item.getQuality();
    }

    public void setQuality(int quality) {
        this.item.setQuality(quality);
    }
}
