package com.me;

import com.me.updates.AbstractUpdate;

import java.util.HashMap;
import java.util.Optional;

public class ShopManager {
    static void displayList(HashMap<Item, AbstractUpdate> items){
        System.out.println("****************************************");
        for (Item it : items.keySet()){
            displayItem(it);
        }
        System.out.println("****************************************");
    }
    static void displayItem(Item item){
        System.out.println("Name : " + item.getName());
        System.out.println("SellIn : " + item.getSellIn());
        System.out.println("Quality : " + item.getQuality() + "\n");
    }
    public static Item get(HashMap<Item, AbstractUpdate> items, String name){
        Optional<Item> optional = items
                .keySet()
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new IllegalStateException("not in shop");
        }
    }
}
