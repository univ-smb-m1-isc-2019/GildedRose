import java.util.ArrayList;
import java.util.List;

public class Main {


    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Gilded Rose");
        GildedRose app = new GildedRose();

        for (int i = 0; i < Integer.valueOf(args[0]) ; i++) {
            app.updateQuality();
        }

    }
}
