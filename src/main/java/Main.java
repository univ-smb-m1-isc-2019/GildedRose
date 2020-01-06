public class Main {

    public static void main(String args[]){

        GildedRose inn = new GildedRose();
        inn.init();
        inn.printItems();
        inn.updateQuality();
        System.out.println("======== update ========");
        inn.printItems();
    }
}
