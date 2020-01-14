public class BackstageUpdater {
    public void updateQuality(Item item){
        if (item.getQuality() < 50){
            if (item.getSellIn() > 10)
                item.setQuality(item.getQuality() + 1);
            else if (item.getSellIn() > 5)
                item.setQuality(item.getQuality() + 2);
            else if (item.getSellIn() > 0)
                item.setQuality(item.getQuality() + 3);
        }
        if (item.getQuality() > 50)
            item.setQuality(50);
    }
}
