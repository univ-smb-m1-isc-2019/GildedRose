import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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
        initListItem();
    }

    public void initListItem()
    {
        ajouterItem(new CommonItem("+5 Dexterity Vest", 10, 20));
        ajouterItem(new CommonItem("Aged Brie", 2, 0));
        ajouterItem(new CommonItem("Elixir of the Mongoose", 5, 7));
        ajouterItem(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
        ajouterItem(new CommonItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        ajouterItem(new ConjuredItem("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality()
    {
        for (int i = 0; i < itemsSize(); i++)
        {
            if ((!isBrie(i)) && !isBackstage(i))
            {
                if (getItemQuality(i) > getMinimalValue())
                {
                    if (!isSulfuras(i))
                    {
                        decrementItemQuality(i);
                    }
                }
            }
            else
            {
                if (getItemQuality(i) < getMaximalValue())
                {
                    incrementItemQuality(i);

                    if (isBackstage(i))
                    {
                        if (getItemSellIn(i) < getIncreaseByTwo())
                        {
                            if (getItemQuality(i) < getMaximalValue())
                            {
                                incrementItemQuality(i);
                            }
                        }

                        if (getItemSellIn(i) < getIncreaseByThree())
                        {
                            if (getItemQuality(i) < getMaximalValue())
                            {
                                incrementItemQuality(i);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(i))
            {
                decrementItemSellIn(i);
            }

            if (getItemSellIn(i) < getMinimalValue())
            {
                if (!isBrie(i))
                {
                    if (!isBackstage(i))
                    {
                        if (getItemQuality(i) > getMinimalValue())
                        {
                            if (!isSulfuras(i))
                            {
                                decrementItemQuality(i);
                            }
                        }
                    }
                    else
                    {
                        setItemQuality(i,getMinimalValue());
                    }
                }
                else
                {
                    if (getItemQuality(i) < getMaximalValue())
                    {
                        incrementItemQuality(i);
                    }
                }
            }
        }
    }


    public boolean isSulfuras(int position)
    {
        return "Sulfuras, Hand of Ragnaros".equals(getItemName(position));
    }

    public boolean isBrie(int position)
    {
        return "Aged Brie".equals(getItemName(position));
    }

    public boolean isBackstage(int position)
    {
        return "Backstage passes to a TAFKAL80ETC concert".equals(getItemName(position));
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

    public int getItemQuality(int position)
    {
        return getItems().get(position).getQuality();
    }

    public void setItemQuality(int position, int value)
    {
        getItems().get(position).setQuality(value);
    }

    public String getItemName(int position)
    {
        return getItems().get(position).getName();
    }

    public void setMaximalValue(int value) {
        maximalValue = value;
    }

    public void setMinimalValue(int value) {
        minimalValue = value;
    }

    public int getMinimalValue(){ return minimalValue; }

    public  int getMaximalValue(){ return maximalValue; }

    public int getItemSellIn(int position)
    {
        return getItems().get(position).getSellIn();
    }

    public void setItemSellIn(int position, int value)
    {
        getItems().get(position).setSellIn(value);
    }

    public void incrementItemQuality(int position)
    {
        setItemQuality(position,getItemQuality(position) + 1);
    }
    public void decrementItemQuality(int position)
    {
        setItemQuality(position,getItemQuality(position) - 1);
    }
    public void decrementItemSellIn(int position)
    {
        setItemSellIn(position,getItemSellIn(position) - 1);
    }

    public void setIncreaseByTwo(int value)
    {
        increaseByTwo = value;
    }
    public void setIncreaseByThree(int value)
    {
        increaseByThree = value;
    }

    public int getIncreaseByTwo()
    {
        return increaseByTwo;
    }
    public int getIncreaseByThree()
    {
        return increaseByThree;
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