public class AmelioratedItem {

    public Item item;
    public boolean conjured;

    public AmelioratedItem(Item item, boolean conjured){
        this.setItem(item);
        this.setConjured(conjured);
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public boolean getConjured(){
        return this.conjured;
    }

    public void setConjured(boolean conjured){
        this.conjured = conjured;
    }

}
