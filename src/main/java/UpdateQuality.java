import java.util.List;

public class UpdateQuality {

    public void UpdateQuality(List<ResetItem> itemList) {
        for (ResetItem item : itemList) {
            modify(item);
        }
    }

    public void modify(ResetItem conjuredItem) {
        Item items = conjuredItem.getItem();
        int degrade = conjuredItem.isConjured() ? 2 : 1;

        if ((!"Aged Brie".equals((items.getName()))) && !"Backstage passes to a TAFKAL80ETC concert".equals((items.getName()))) {
            if (items.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals((items.getName()))) {
                    items.setQuality((items.getQuality() - degrade));
                }
            }
        } else {
            if (items.getQuality() < 50) {
                items.setQuality(items.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(items.getName())) {
                    if (items.getSellIn() < 11) {
                        if (items.getQuality() < 50) {
                            items.setQuality(items.getQuality() + 1);
                        }
                    }

                    if (items.getSellIn() < 6) {
                        if (items.getQuality() < 50) {
                            items.setQuality(items.getQuality() + 1);
                        }
                    }
                }
            }
        }
        if (!"Sulfuras, Hand of Ragnaros".equals(items.getName())) {
            items.setSellIn(items.getSellIn() - 1);
        }
    }

    public void update_sellin(ResetItem conjuredItem) {
        Item items = conjuredItem.getItem();
        int degrade = conjuredItem.isConjured() ? 2 : 1;

        if (items.getSellIn() < 0) {
            if (!"Aged Brie".equals(items.getName())) {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.getName())) {
                    if (items.getQuality() > 0) {
                        if (!"Sulfuras, Hand of Ragnaros".equals(items.getName())) {
                            items.setQuality(items.getQuality() - degrade);
                        }
                    }
                } else {
                    items.setQuality((items.getQuality() - items.getQuality()));
                }
            } else {
                if (items.getQuality() < 50) {
                    items.setQuality(items.getQuality() + 1);
                }
            }
        }
    }


}