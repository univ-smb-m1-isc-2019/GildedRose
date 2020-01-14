public class AgedBrieUpdate {
    public void updateQuality(Item item){
        if (item.getQuality() < 50)
            item.setQuality(item.getQuality() + 1);
    }
}
