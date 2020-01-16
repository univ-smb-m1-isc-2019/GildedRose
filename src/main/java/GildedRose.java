import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class GildedRose {

	private List<MyItem> items = null;



	public GildedRose()
    {
        initListItems();


        initItems();
    }

    public void initItems()
    {
        ajouterItem(new CommonItem("+5 Dexterity Vest", 10, 20));
        ajouterItem(new AgedBrie("Aged Brie", 2, 0));
        ajouterItem(new CommonItem("Elixir of the Mongoose", 5, 7));
        ajouterItem(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        ajouterItem(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        ajouterItem(new ConjuredItem("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality()
    {
        for (int i = 0; i < itemsSize(); i++)
        {
            System.out.println(getItems().get(i).getClass().getName());
        }
    }

    public List<MyItem> getItems()
    {
        return items;
    }

    public void initListItems()
    {
        items = new ArrayList<MyItem>();
    }

    public void ajouterItem(MyItem item)
    {
        getItems().add(item);
    }

    public int itemsSize()
    {
        return items.size();
    }

    public Item get(String nom)
    {
        Optional<Item> optional = getItems().stream()
                .filter(item -> item.getName().equals(nom))
                .findFirst();

        if(optional.isPresent())
        {
            return optional.get();
        }
        else {
            throw new IllegalStateException("Not found in shop");
        }
    }

    public List<Item> getNonLegendaryItems()
    {
        List<Item> list = getItems().stream()
                .filter(item -> !item.getClass().getName().equals("LegendaryItem"))
                .collect(Collectors.toList());

        return list;
    }
}