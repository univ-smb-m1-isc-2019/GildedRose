import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GildedRose {

    private static ArrayList<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");

        //Crée une liste vide pour les items
        items = new ArrayList<Item>();

        //Crée la liste des items
        ManageList.create_list_item(items);

        //Met à jour les données des items
        UpdateQuality.updateQuality(items);

        //Affiche items
        ManageList.display_list(items);

    }


	


}