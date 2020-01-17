package com.me;

import com.me.updates.*;

import java.util.HashMap;

public class GildedRose {

	public HashMap<Item, AbstractUpdate> items;
	public GildedRose(){
	    this.items = createShop();
    }
    private HashMap<Item, AbstractUpdate> createShop(){
	    HashMap<Item, AbstractUpdate> items = new HashMap<>();
        items.put(new Item("+5 Dexterity Vest", 10, 5), new StandardUpdate());
        items.put(new Item("Aged Brie", 2, 0), new AgedBrieUpdate());
        items.put(new Item("Elixir of the Mongoose", 5, 7), new StandardUpdate());
        items.put(new Item("Sulfuras, Hand of Ragnaros", 0, 80), new LegendaryUpdate());
        items.put(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 35), new BackstageUpdate());
        items.put(new Item("Conjured Mana Cake", 3, 6), new ConjuredUpdate());
        return items;
    }
    public void updateQuality()
    {
        for (Item item : items.keySet()){
            items.get(item).updateQuality(item);
        }
    }

}