import java.util.List;


public class GildedRose {

	private static List<CorruptedItem> items = null;
	private Stock stock = new Stock();
	private Treatment treatment = new Treatment();
	private Result result = new Result();


	public  void gildedRose() {
        items = stock.addAllItem(items);
        treatment.updateQuality(items);
        result.showResult(items);
}


	


}