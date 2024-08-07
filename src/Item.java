/** Represents an Item.
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/
public class Item {
    private String name;
    private int quantity;
    private String category;
    private boolean crossed;

    /**
     * Default constructor
     */
    public Item() {
        this.name = "Unknown";
        this.quantity = 0;
        this.category = "Unknown";
        this.crossed = false;
    }

    /**
     * Parameterized Constructor
     * @param name the new value for this.name
     * @param category the new value for this.category
     */
    public Item(String name, String category) {
        this.name = name;
        this.quantity = 1;
        this.category = category;
        this.crossed = false;
    }

    /**
     * Parameterized Constructor
     * @param name the new value for this.name
     * @param quantity the new value for this.quantity
     * @param category the new value for this.category
     */
    public Item(String name, int quantity, String category){
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.crossed = false;
    }

    /**
     * Name mutator
     * @param name the new value for this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Quantity mutator
     * @param quantity the new value for this.quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Category mutator
     * @param category the new value for this.category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Switches the value of crossed based off its current value.
     * True would change to false,
     * false would change to true
     */
    public void toggleCross() {
        if(crossed) {
            this.crossed = false;
        } else {
            this.crossed = true;
        }
    }

    /**
     * Name accessor
     * @return the private name variable
     */
    public String getName() {
        return name;
    }

    /**
     * Quantity accessor
     * @return the private quantity variable
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Category accessor
     * @return the private category variable
     */
    public String getCategory() {
        return category;
    }

     /**
     * crossed accessor
     * @return the private crossed variable
     */
    public boolean isCrossed() {
        return crossed;
    }
}