package inn;

import java.util.List;


public class GildedRose {



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		//On cree l'inventaire de la taverne sous forme de liste
		//puis on applique l'algorithme de gestion de qualite/tps restant pour la vente sur cette liste

		Stock goods = new Stock();
		QualityManager qm = new QualityManager();
		qm.updateQuality(goods.getItems());
	}
}