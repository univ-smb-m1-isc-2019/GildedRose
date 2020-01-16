import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class GildedRose {

	private List<Item> items = null;
	private int minimalValue ;
	private int maximalValue ;
	private int increaseByTwo;
	private int increaseByThree;


	public GildedRose()
    {
        initListItems();

        setMinimalValue(0);
        setMaximalValue(50);
        setIncreaseByTwo(11);
        setIncreaseByThree(6);

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

        }
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void initListItems()
    {
        items = new ArrayList<Item>();
    }

    public void ajouterItem(Item item)
    {
        getItems().add(item);
    }

    public int itemsSize()
    {
        return items.size();
    }
    


    public void setMaximalValue(int value) {
        maximalValue = value;
    }

    public void setMinimalValue(int value) {
        minimalValue = value;
    }



    public void setIncreaseByTwo(int value)
    {
        increaseByTwo = value;
    }
    public void setIncreaseByThree(int value)
    {
        increaseByThree = value;
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
                .filter(item -> item.getClass().getName().equals("CommonItem") || item.getClass().getName().equals("ConjuredItem"))
                .collect(Collectors.toList());

        return list;
    }
}