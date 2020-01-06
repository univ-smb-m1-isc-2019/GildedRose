package inn;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    //Classe Stock qui gere les donnees : les differents
    //items disponibles dans la taverne avec les caracteristiques
    //propre a chacun

    private static List<CorruptedItem> items = null;

    public Stock() {

        this.items = new ArrayList<>();
        //On cree un item en lui donnant un nom, un tps restant pour la vente et une qualite
        this.items.add(new CorruptedItem(new Item("+5 Dexterity Vest", 10, 20), false));
        this.items.add(new CorruptedItem(new Item("Aged Brie", 2, 0),false));
        this.items.add(new CorruptedItem(new Item("Elixir of the Mongoose", 5, 7), false));
        this.items.add(new CorruptedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80),false));
        this.items.add(new CorruptedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),false));
        this.items.add(new CorruptedItem(new Item("Conjured Mana Cake", 3, 6),true));


    }
    public static List<CorruptedItem> getItems() {
        return items;
    }
}
