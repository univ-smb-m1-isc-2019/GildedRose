public abstract class CustomItem {

    private Item item;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateItem();
}
