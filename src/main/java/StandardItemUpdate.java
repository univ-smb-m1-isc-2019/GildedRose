public class StandardItemUpdate {

    public void updateQuality(Item item){
       if (item.getQuality() > 0)
           item.setQuality(item.getQuality() - 1);
    }
}
