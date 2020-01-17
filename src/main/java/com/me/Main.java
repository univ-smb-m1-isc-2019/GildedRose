package com.me;

public class Main {

    public static void main(String[] args) {

        GildedRose gr = new GildedRose();
        ShopManager.displayList(gr.items);
        gr.updateQuality();
        ShopManager.displayList(gr.items);
    }

}
