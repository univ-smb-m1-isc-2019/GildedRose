public interface ItemInterface {
    public void changeQualityOf(int n);

    public void sellInPassed();

    public String getName();

    public void setName(String name);

    public int getSellIn();

    public void setSellIn(int sellIn);

    public int getQuality();

    public void setQuality(int quality);

    public void updateQuality();

    int getQualityAmountToChange();

    int getMaximumQuality();
}
