import java.util.List;
import java.util.Optional;


public class GildedRose {

	private static List<CorruptedItem> items = null;
	public Stock stock = new Stock();
	public Treatment treatment = new Treatment();
	public Result result = new Result();


	public void gildedRose() {
        items = stock.addAllItem(items);
		treatment.updateQuality(items);
		result.showResult(items);

	}



	public void addAllItem(){
		items = stock.addAllItem(items);
	}

	public void updateQuality(){
		treatment.updateQuality(items);
	}

	public CorruptedItem getItem(String key){
		Optional<CorruptedItem> optional = items.stream()
				.filter(item -> item.getItem().getName().equals(key))
				.findFirst();
		return optional.get();

	}

	public List<CorruptedItem> getItems(){
		return items;
	}


	


}