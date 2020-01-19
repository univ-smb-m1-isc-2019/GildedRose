import java.util.Optional;

public class GildedRose {

    private Storage storage;

	public GildedRose(){
        this.storage = new Storage();
        this.storage.updateStorage();
    }

    public Item get(String itemName) {
        Optional<Item> optional = this.storage.getListItems().stream().filter(item -> item.getName().equals(itemName)).findFirst();
        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new IllegalStateException("Item not found");
        }
    }

    public void updateGildedRose(){
        this.storage.updateStorage();
    }

    public Storage getStorage() {
        return this.storage;
    }
}