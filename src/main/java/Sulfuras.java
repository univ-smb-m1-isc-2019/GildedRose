public class Sulfuras extends ItemCreate {
    public Sulfuras( int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

  //Sulfuras item's quality should never change this is why the methode is empty
    public static void  doUpdateQuality(Item item){

    }

}
