public abstract class ItemUpdate implements UpdateInterface {
    protected int adjust_quality = quality_ajust;
    public void updateQuality(Item item){

        if(item.getSellIn() < sell_in_min)
            adjust_quality = adjust_quality * 2;

        item.setQuality(item.getQuality() + adjust_quality);
        if (item.getQuality() < min_quality)
            item.setQuality(min_quality);
        if (item.getQuality() > max_quality)
            item.setQuality(max_quality);
        item.setSellIn(item.getSellIn() + sell_in_adjust);
    }
}
