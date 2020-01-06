import java.util.List;


public class GildedRose {

	private static List<CorruptedItem> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        items = Stock.addAllItem(items);
        Treatment.updateQuality(items);
        Result.showResult(items);
}


	


}