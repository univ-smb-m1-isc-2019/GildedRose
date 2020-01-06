import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

	private List<AdvancedItem> itemList = null;

    public  GildedRose() {
        ItemList i = new ItemList();
        itemList = i.createList();

}

    public Item get(String key) {
        Optional<AdvancedItem> optional = itemList.stream()
                .filter(item -> item.getItem().getName().equals(key) )
                .findFirst();

        if (optional.isPresent()){
            return optional.get().getItem();

        }else{
            throw new IllegalStateException("not found in shop");
        }
    }

    public List<AdvancedItem> getItemList() {return itemList;}

    public void setItemList(List<AdvancedItem> itemList) {this.itemList = itemList;}
}