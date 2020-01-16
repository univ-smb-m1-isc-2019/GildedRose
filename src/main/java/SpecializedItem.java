public abstract class SpecializedItem {
	//This class is just a superClass for differents kinds of items. It does not need to be instancied.
	protected final static int QUALITY_MAX= 50;
    public String name;
	public int sellIn;
    public int quality;

    public SpecializedItem(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellIn() {
		return sellIn;
	}
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}

	//This method is implemented different way for each kind of item
	public abstract void updateQuality();

}
