import java.util.Optional;


public class GildedRose {

    private Stock stock;
    private QualityItemsManager qualityItemsManager;

    public Stock getGoods() {
        return this.stock;
    }

    public QualityItemsManager getQualityItemsManager() {
        return qualityItemsManager;
    }

    public GildedRose() {
        //Création de l'inventaire de la taverne
        //Application de l'algorithme de gestion de qualité des items
        this.stock = new Stock();
        this.qualityItemsManager = new QualityItemsManager();
    }

    public Item get(String itemName) {
        Stock stock = new Stock();
        Optional<Item> optional =
                stock.getItems().stream()
                        .filter(item -> item.getName().equals(itemName))
                        .findFirst();

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalStateException("pas trouvé");
        }


    }

    public void updateQuality() {

        this.stock.getItems().stream()
                .forEach(x -> {
                    qualityItemsManager.updateQuality2(x);
                });
    }

    public void updateQuality(Item item) {
        qualityItemsManager.updateQuality2(item);
    }
}
