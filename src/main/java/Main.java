import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CreateItemList myItemList = new CreateItemList();
        myItemList.createList();

        GildedRose gRose = new GildedRose(myItemList.getItems());
        gRose.updateQuality();
    }

}
