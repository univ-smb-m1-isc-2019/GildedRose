import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

    private List<ResetItem> itemList = null;

    public GildedRose() {
        ItemList il = new ItemList();
        itemList = il.init();
    }


    public void printItems() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i).getItem().getName() + " : " + itemList.get(i).getItem().getSellIn() + "(sell) , " +
                    itemList.get(i).getItem().getQuality() + "(quality)");
        }
    }

    public List<ResetItem> getItemList(){
        return itemList;
    }

    public void setItemList(List<ResetItem> itemList){
        this.itemList = itemList;
    }

    public Item get(String key) {

        Optional<ResetItem> optional = itemList.stream()
                .filter(items -> items.getItem().getName().equals(key))
                .findFirst();

        if (optional.isPresent()) {
            return optional.get().getItem();
        } else {
            throw new IllegalStateException("Not found in shop");
        }
    }
}