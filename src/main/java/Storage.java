import java.util.ArrayList;

public class Storage {

    private ArrayList<Item> listItems;

    private QualityUpdate qualityUpdate;

    public Storage(){

        this.listItems = new ArrayList<Item>();
        this.addItems();
        this.qualityUpdate = new QualityUpdate();
    }

    public void addItems(){
        this.listItems.add(new Item("+5 Dexterity Vest", 10, 20));
        this.listItems.add(new Item("Aged Brie", 2, 0));
        this.listItems.add(new Item("Elixir of the Mongoose", 5, 7));
        this.listItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        this.listItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        this.listItems.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateStorage(){
        for (Item item : this.listItems) {
            System.out.println(item.getName());
            System.out.println(item.getQuality());
            System.out.println(item.getSellIn());
            this.qualityUpdate.updateQuality(item);
            System.out.println(item.getQuality());
            System.out.println(item.getSellIn());

        }
    }
}
