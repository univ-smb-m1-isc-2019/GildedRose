package exceptions;

public class ItemNotFoundInShop extends Exception {

    public ItemNotFoundInShop(String itemName) {
        System.out.println("We are not selling any item called \"" + itemName + "\"! Please add it to the shop.");
    }

}
