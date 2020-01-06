package inn;

import java.util.List;

//Gestion du tps restant pour la vente et de la qualite d'un item
public class QualityManager {

    private int rateLowering = 1;

    public int getRateLowering() {
        return rateLowering;
    }

    public void setRateLowering(int rateLowering) {
        this.rateLowering = rateLowering;
    }

    //definition du taux de deterioration de la qualite en fonction de la corruption
    public void setRate(CorruptedItem item){
        if (item.isCorrupted()){
            setRateLowering(2);
        }else{
            setRateLowering(1);
        }
    }

    //nom de l'item courant
    private static String currentName(List<CorruptedItem> items, int i){
        return items.get(i).getItem().getName();
    }

    //qualite de l'item courant
    private static int currentQuality(List<CorruptedItem> items, int i){
        return items.get(i).getItem().getQuality();
    }

    //tps restant pour la vente de l'item courant
    private static int currentSellIn(List<CorruptedItem> items, int i){
        return items.get(i).getItem().getSellIn();
    }

    //incrémentation de la qualite dans un cas normal = +1
    private void normIncreaseQuality(List<CorruptedItem> items, int i) {
        items.get(i).getItem().setQuality((currentQuality(items,i) + 1)*getRateLowering());

    }

    //decrementation de la qualite dans un cas normal = -1
    public void normLowerQuality(List<CorruptedItem> items, int i){
        //Case: normal decrease

            if (currentQuality(items,i) > 0) {
                if (!testName("Sulfuras, Hand of Ragnaros", currentName(items,i))) {
                    items.get(i).getItem().setQuality((currentQuality(items,i) - 1)*getRateLowering());
                }
            }
            }

    //incrementation qualite cas special = +2 ou +3
    public void increaseQualitySpe(List<CorruptedItem> items, int i){
        if (currentQuality(items,i) < 50) {
            items.get(i).getItem().setQuality((currentQuality(items,i) + 1)*getRateLowering());

            if (testName("Backstage passes to a TAFKAL80ETC concert", currentName(items,i))) {
                if (currentSellIn(items,i) < 11) {
                    if (currentQuality(items,i) < 50) {
                        items.get(i).getItem().setQuality((currentQuality(items,i) + 1)*getRateLowering());
                    }
                }

                if (currentSellIn(items,i) < 6) {
                    if (currentQuality(items,i) < 50) {
                        items.get(i).getItem().setQuality((currentQuality(items,i) + 1)*getRateLowering());
                    }
                }
            }
        }
    }

    //decrementation du temps restant pour la vente
    public void lowerSellIn(List<CorruptedItem> items, int i){
        items.get(i).getItem().setSellIn((currentSellIn(items,i) - 1)*getRateLowering());
    }

    //on donne un nom d'item et le nom a tester et on renvoie si c'est le meme ou non
    public boolean testName(String name, String testedName){
        return name.equals(testedName);
    }

    //apres utilisation du ticket (=un item de la liste) il perd toute sa qualite
    private void afterConcert(List<CorruptedItem> items, int i) {
        items.get(i).getItem().setQuality(currentQuality(items,i) - currentQuality(items,i));
    }

    //Gestion generale du stock:
    //on parcourt la liste d'item et on met a jour le tps restant pour la vente et la qualite
    //en fonction des regles de la taverne
    public void updateQuality(List<CorruptedItem> items) {
        for (int i = 0; i < items.size(); i++) {
            //redefinition du taux de baisse de la qualite si l'item est corrompu ou non
            setRate(items.get(i));

            if ((!testName("Aged Brie", currentName(items,i))) && !testName("Backstage passes to a TAFKAL80ETC concert", currentName(items,i))) {
                normLowerQuality(items,i);
            } else {
                increaseQualitySpe(items, i);
            }

            if (!testName("Sulfuras, Hand of Ragnaros", currentName(items,i))) {
                lowerSellIn(items, i);
            }

            if (currentSellIn(items,i) < 0) {
                if (!testName("Aged Brie", currentName(items,i))) {
                    if (!testName("Backstage passes to a TAFKAL80ETC concert", currentName(items,i))) {
                        normLowerQuality(items, i);

                    } else {
                        afterConcert(items,i);

                    }
                } else {
                    if (currentQuality(items,i) < 50) {
                        normIncreaseQuality(items, i);
                    }
                }
            }
        }
    }


}
