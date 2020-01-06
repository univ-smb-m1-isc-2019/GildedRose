import java.util.ArrayList;

public class UpdateQuality {

    //Met à jour les données des items
    public  void updateQuality(ArrayList<Item> items)
    {
        for (Item item :items)
        {
            ConditionQuality CQ = new ConditionQuality();

            CQ.decrease_quality(item);

            CQ.decrease_sellIn(item);

            CQ.decrease_quality_sellIn_wrong(item);

            CQ.decrease_quality_item_conjured(item);
        }
    }
}
