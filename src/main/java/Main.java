public class Main {

    public static void main(String args[]){

        GildedRose inn = new GildedRose();
        UpdateQuality uq = new UpdateQuality();
        inn.printItems();
        System.out.println("======== update ========");
        uq.UpdateQuality(inn.getItemList());
        inn.printItems();
    }
}
