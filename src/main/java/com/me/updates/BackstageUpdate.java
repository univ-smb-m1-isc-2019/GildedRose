package com.me.updates;

import com.me.Item;

public class BackstageUpdate extends AbstractUpdate {
    public BackstageUpdate(){
        this.adjust_quality = 1;
    }

    public void updateQuality(Item item){

        if (6 <= item.getSellIn() && item.getSellIn() <= 10)
            adjust_quality = 2;
        else if (sell_in_min <= item.getSellIn() && item.getSellIn() <= 5)
            adjust_quality = 3;
        if(item.getSellIn() < 0){
            item.setQuality(0);
        }else {
            item.setQuality(item.getQuality() + adjust_quality);
        }
        qualityLimitsControl(item);
        updateSellIn(item);
    }
}
