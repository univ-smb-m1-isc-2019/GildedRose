
public class Main {

    public static void main(String[] args) {
        CreateItemList myItemList = new CreateItemList();

        GildedRose gRose = new GildedRose(myItemList.getItems());
        gRose.updateQuality();
    }

}
