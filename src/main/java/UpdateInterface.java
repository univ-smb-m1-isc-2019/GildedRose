public interface UpdateInterface {
    int max_quality = 50;
    int min_quality = 0;
    int quality_ajust = -1;
    int sell_in_min = 0;
    int sell_in_adjust = -1;
    void updateQuality(Item item);
}
