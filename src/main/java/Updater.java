public class Updater {
    public StandardItemUpdate standardItemUpdate;
    public ConjuredItemUpdate conjuredItemUpdate;
    public AgedBrieUpdate agedBrieUpdate;
    public BackstageUpdater backstageUpdater;
    public Updater(){
        standardItemUpdate = new StandardItemUpdate();
        conjuredItemUpdate = new ConjuredItemUpdate();
        agedBrieUpdate = new AgedBrieUpdate();
        backstageUpdater = new BackstageUpdater();
    }
}
