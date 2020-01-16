public class ResetItem {

    public Item item;
    public boolean conjured;

    public ResetItem(Item item, boolean conjured){
        this.setItem(item);
        this.setConjured(conjured);
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public boolean isConjured(){
        return this.conjured;
    }

    public void setConjured(boolean conjured){
        this.conjured = conjured;
    }

}
