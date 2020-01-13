
public abstract class Item {
	//This class will never been instancied itself. It regroups subclasses and their methods.
	protected final static int QUALITY_MAX= 50;
    protected String name;
	protected int sellIn;
    protected int quality;
    
    public Item(String name, int sellIn, int quality) {
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

	public void updateQuality(){}

}
