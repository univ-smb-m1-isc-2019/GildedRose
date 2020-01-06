import java.util.ArrayList;

public class UpdateQuality {

    //Met à jour les données des items
    public static void updateQuality(ArrayList<Item> items)
    {
        for (Item item :items)
        {
            ConditionQuality.decrease_quality(item);

            ConditionQuality.decrease_sellIn(item);

            ConditionQuality.decrease_quality_sellIn_wrong(item);

            ConditionQuality.decrease_quality_item_conjured(item);
        }
    }
}
