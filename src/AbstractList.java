import java.util.HashSet;


/** An Abstract class in which the ShoppingList and Store class extends. 
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/

abstract class AbstractList {
    protected HashSet<Item> entries = new HashSet<Item>();
    protected String name;
    private final String check = "*";

    /**
     * Name mutator
     * @param newName the new value for this.name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    
     /**
     * Name accessor
     * @return the private name variable
     */
    public String getName() {
        return this.name;
    }

    /**
     * addItem
     * @param newItem adds this item to the entries HashSet
     * @return a boolean value
     */
    public boolean addItem(Item newItem) {
        return entries.add(newItem);
    }

    /**
     * removeItem
     * @param removeThis removes this item from the entries HashSet
     * @return a boolean value
     */
    public boolean removeItem(Item removeThis) {
        return entries.remove(removeThis);
    }

    /**
     * contains- checks if entries HashSet has a specific item
     * @param item the item to check
     * @return a boolean value
     */
    public boolean contains(Item item) {
        return entries.contains(item);
    }

    /**
     * size- returns the number of items in the list
     * @return an int value
     */
    public int size() {
        return entries.size();
    }

    /**
     * getItemByName- Finds an item by its name in list and returns it
     * @param name the name to search for
     * @return an Item object
     */
    public Item getItemByName(String name) {
        for (Item i : entries) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        Item invalid = new Item("INVALID", "INVALID");
        return invalid;
    }

    /**
     * Prints all items in the entries HashSet in a table format
     */
    public void printList() {
        final int WIDTH = 75; // 75 = 15 * 4 + 15 other chars
        //System.out.printf("===== %s =====\n", this.name);
        for(int i = 0; i < (WIDTH/2) - this.name.length()/2 - 1; i++) {
            System.out.print("=");
        }
        System.out.printf(" %s ", this.name);
        for(int i = 0; i < (WIDTH/2) - this.name.length()/2 - 1; i++) {
            System.out.print("=");
        }
        System.out.println();

        System.out.printf("%s  | %-15s | %-15s | %-15s | %-15s\n", "#", "Item", "Quantity", "Category", "Acquired");
        for(int i = 0; i < WIDTH; i++) { 
            System.out.print("-");
        }
        System.out.println();

        int counter = 1;
        for(Item i : entries) {
            if(i.isCrossed()) {
                System.out.printf("%d. | %-15s | %-15s | %-15s | %-15s\n", counter, i.getName(), i.getQuantity(), i.getCategory(), check);
            } else {
                System.out.printf("%d. | %-15s | %-15s | %-15s |\n", counter, i.getName(), i.getQuantity(), i.getCategory());
            }
            ++counter;
        }
        
        for(int i = 0; i < WIDTH; i++) { 
            System.out.print("=");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Prints all items in the entries HashSet as a simple list
     */
    public void printListSimple() {
        for (Item i : entries) {
            System.out.printf("%s\n", i.getName());
        }
    }
}