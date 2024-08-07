/** Represents an Store, extends AbstractList.
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/
public class Store extends AbstractList {
    private String description;

    /**
     * Default constructor
     */
    public Store() {
        this.name = "Store";
        this.description = "A generic store";
    }

    /**
     * Parameterized Constructor
     * @param name the new value for this.name
     * @param description the new value for this.description
     */
    public Store(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Description mutator
     * @param description the new value for this.description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Name accessor
     * @return the private name variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * Description accessor
     * @return the private Description variable
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * inStock
     * @param item 
     * @return A boolean which is true if the entries HashSet in the AbstractList class contains item, and false if it does not contain item.
     */
    public boolean inStock(Item item) {
        return this.contains(item);
    }
}