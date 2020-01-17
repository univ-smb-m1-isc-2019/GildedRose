package com.me.updates;

import com.me.Item;

public abstract class AbstractUpdate {
    int max_quality = 50;
    int min_quality = 0;
    int sell_in_min = 0;
    int adjust_quality = -1;
    int sell_in_adjust = -1;
    boolean sell_in_limit_reached = false;

    public void updateQuality(Item item){
        if(!sell_in_limit_reached)
            sellInLimitControl(item);
        item.setQuality(item.getQuality() + adjust_quality);
        qualityLimitsControl(item);
        updateSellIn(item);
    }

    protected void updateSellIn(Item item){
        item.setSellIn(item.getSellIn() + sell_in_adjust);
    }

    private void sellInLimitControl(Item item){
        if(item.getSellIn() < sell_in_min){
            sell_in_limit_reached = true;
            adjust_quality = adjust_quality * 2;
        }
    }

    protected void qualityLimitsControl(Item item){
        if (item.getQuality() < min_quality)
            item.setQuality(min_quality);
        if (item.getQuality() > max_quality)
            item.setQuality(max_quality);
    }
}
