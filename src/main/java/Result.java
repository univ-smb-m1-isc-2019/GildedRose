import java.util.List;

public class Result {
    public  void showResult(List<CorruptedItem> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getItem().getName() + " : Quality = " + items.get(i).getItem().getQuality()
                    + " SellIn = " + items.get(i).getItem().getSellIn() + " isCorrupted = " + items.get(i).getIsCorrupted());
        }
    }
}
