public class BackstageUpdate extends ItemUpdate {
    public BackstageUpdate(){
        adjust_quality = 1;
    }
    public void updateQuality(Item item){

        if (item.getQuality() < max_quality){
            if (6 <= item.getSellIn() && item.getSellIn() <= 10)
                adjust_quality = 2;
            else if (sell_in_min <= item.getSellIn() && item.getSellIn() <= 5)
                adjust_quality = 3;
            item.setQuality(item.getQuality() + adjust_quality);
        }
        if (item.getQuality() > max_quality)
            item.setQuality(max_quality);
        if (item.getSellIn() < sell_in_min)
            item.setQuality(min_quality);
        item.setSellIn(item.getSellIn() + sell_in_adjust);
    }
}
