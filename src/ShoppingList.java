import java.util.ArrayList;
import java.util.List;

/** Represents an ShoppingList of Items to be collected at a specific store, extends AbstractList.
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/
public class ShoppingList extends AbstractList {
    private Store storeForList;
    private List<Item> items = new ArrayList<>();
    /**
     * Default constructor
     */
    public ShoppingList() {
        this.name = "New List";
        Store blankStore = new Store("None", "No store specified");
        this.storeForList = blankStore;
    }

    /**
     * Parameterized Constructor
     * @param name the new value for this.name
     */
    public ShoppingList(String name) {
        this.name = name;
        Store blankStore = new Store("None", "No store specified");
        this.storeForList = blankStore;
    }

    /**
     * Parameterized Constructor
     * @param name the new value for this.name
     * @param setStore the new value for this.storeForList
     */
    public ShoppingList(String name, Store setStore) {
        this.name = name;
        this.storeForList = setStore;
    }

    /**
     * Store mutator
     * @param storeForList the new value for this.storeForList
     */
    public void setStoreForList(Store storeForList) {
        this.storeForList = storeForList;
    }

    /**
     * ShoppingList accessor
     * @return the private name variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * ShoppingList accessor
     * @return a Store object
     */
    public Store getStore() {
        return storeForList;
    }

    /**
     * Store accessor
     * @return the number of items in the list
     */
    public int numItems() {
        return this.size();
    }

    public List<Item> getItems() {
        return items;
    }
}