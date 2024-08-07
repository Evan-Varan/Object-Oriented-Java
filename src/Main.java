import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printLists(ArrayList<ShoppingList> lists) {
        int counter = 1;
        System.out.println("My shopping lists:");
        for (ShoppingList i : lists) {
            System.out.printf("%d. %s\tNumber of items: %d\n", counter, i.getName(), i.size());
            ++counter;
        }
        System.out.println();
    }

    public static void printStores(ArrayList<Store> stores) {
        int counter = 1;
        System.out.println("Stores");
        for (Store i : stores) {
            System.out.printf("%d. %s: %s", counter, i.getName(), i.getDescription());
            ++counter;
        }
        System.out.println();
    }

    public static void printMainMenu() {
        System.out.println("Choose an option:");
        System.out.println("1: Make a new list");
        System.out.println("2. Edit existing list");
        System.out.println("3. Exit");
        System.out.println();
    }

    public static void executeMainMenu(Scanner scan, ArrayList<ShoppingList> lists, int option) {
        switch (option) {
            case 1:
                System.out.println("Enter name of new list: ");
                String listName = scan.nextLine();
                newList(lists, listName);
                System.out.printf("List \"%s\" has been created!\n\n", listName);
                break;
            case 2:
                System.out.println("Edit which list?\n");
                printLists(lists);
                int listChoice = scan.nextInt();
                scan.nextLine(); // Clear linebreak from scanner
                if(listChoice > lists.size()+1 || listChoice < 1) {
                    System.out.println("Invalid choice\n");
                    break;
                }
                ShoppingList thisList = lists.get(listChoice-1);
                editList(scan, thisList);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public static void editList(Scanner scan, ShoppingList list) {
        int choice = 0;
        while(choice != 5) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Cross/Uncross item");
            System.out.println("4. View list");
            System.out.println("5. Stop editing this list");

            choice = scan.nextInt();
            scan.nextLine(); // Clear linebreak from scanner
            while(choice < 1 || choice > 5) {
                System.out.println("Invalid choice\n");
                System.out.println("Choose an option: ");
                System.out.println("1. Add item");
                System.out.println("2. Remove item");
                System.out.println("3. Cross/Uncross item");
                System.out.println("4. View list");
                System.out.println("5. Stop editing this list");
                choice = scan.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.println("Item name:");
                    String name = scan.nextLine();
                    System.out.println("Quantity:");
                    int qty = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Category:");
                    String category = scan.nextLine();
                    Item newItem = new Item(name, qty, category);
                    list.addItem(newItem);
                    break;
                case 2:
                    System.out.println("Remove which item?");
                    list.printListSimple();
                    String removeName = scan.nextLine();

                    Item removeThis = list.getItemByName(removeName);
                    if(removeThis.getName().equals("INVALID")) {
                        System.out.println("No such item");
                    } else {
                        list.removeItem(removeThis);
                        System.out.printf("%s has been remvoed!\n\n", removeThis.getName());
                    }
                    break;
                case 3: 
                    System.out.println("Cross/uncross which item?");
                    list.printListSimple();
                    String crossName = scan.nextLine();

                    Item crossThis = list.getItemByName(crossName);
                    if(crossThis.getName().equals("INVALID")) {
                        System.out.println("No such item");
                    } else {
                        crossThis.toggleCross();
                        list.printList();
                    }
                    break;
                case 4: 
                    list.printList();
                    break;
                case 5:
                    break;
        }
        
        }
    }

    public static void newList(ArrayList<ShoppingList> lists, String listName) {
        
        ShoppingList newList = new ShoppingList(listName);
        lists.add(newList);
    }


   //Admin Flow 
    public static void printMainMenuAdmin() {
        System.out.println("Choose an option:");
        System.out.println("1: Add a new store");
        System.out.println("2. Edit existing store");
        System.out.println("3. Exit");
        System.out.println();
    }
    public static void executeAdminMenu(Scanner scan, ArrayList<ShoppingList> lists, int option) {
        switch (option) {
            case 1:
                System.out.println("Enter name of new store: ");
                String listName = scan.nextLine();
                newList(lists, listName);
                System.out.printf("Store \"%s\" has been created!\n\n", listName);
                break;
            case 2:
                System.out.println("Edit which store?\n");
                printLists(lists);
                int listChoice = scan.nextInt();
                scan.nextLine(); // Clear linebreak from scanner
                if(listChoice > lists.size()+1 || listChoice < 1) {
                    System.out.println("Invalid choice\n");
                    break;
                }
                ShoppingList thisList = lists.get(listChoice-1);
                editAdminList(scan, thisList);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public static void editAdminList(Scanner scan, ShoppingList list) {
        int choice = 0;
        while(choice != 4) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add item to inventory");
            System.out.println("2. Remove item for inventory");
            System.out.println("3. View store's inventory");
            System.out.println("4. Stop editing this store's inventory");

            choice = scan.nextInt();
            scan.nextLine(); // Clear linebreak from scanner
            while(choice < 1 || choice > 4) {
                System.out.println("Invalid choice\n");
                System.out.println("Choose an option: ");
                System.out.println("1. Add item to inventory");
                System.out.println("2. Remove item for inventory");
                System.out.println("3. View store inventory");
                System.out.println("4. Stop editing this store's inventory");
                choice = scan.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.println("Item name:");
                    String name = scan.nextLine();
                    System.out.println("Quantity:");
                    int qty = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Category:");
                    String category = scan.nextLine();
                    Item newItem = new Item(name, qty, category);
                    list.addItem(newItem);
                    break;
                case 2:
                    System.out.println("Remove which item?");
                    list.printListSimple();
                    String removeName = scan.nextLine();

                    Item removeThis = list.getItemByName(removeName);
                    if(removeThis.getName().equals("INVALID")) {
                        System.out.println("No such item");
                    } else {
                        list.removeItem(removeThis);
                        System.out.printf("%s has been remvoed!\n\n", removeThis.getName());
                    }
                    break;
                case 3: 
                    list.printList();
                    break;
                case 4:
                    break;
        }
        
        }
    }


    public static void main(String[] args) {

        boolean administratorFlow = false;
        Scanner scan = new Scanner(System.in);
        // Create default users
        User james = new User("jrh233", "password");
        User manager = new User("HEBadmin", "admin");
        UserList allUsers = new UserList();
        UserList adminUsers = new UserList();
        allUsers.addUser(manager);
        adminUsers.addUser(manager);
        allUsers.addUser(james);

        //Create a default store
        Store HEB = new Store("HEB", "Texas-based grocery store");
        ArrayList<Store> allStores = new ArrayList<Store>();
        allStores.add(HEB);

        ArrayList<ShoppingList> allLists = new ArrayList<ShoppingList>();


        User me = new User();
        System.out.println("LOGIN");
        System.out.println("=====");

        while(!me.isSignedIn()) {  
            System.out.println("Enter username: ");
            //String username = scan.nextLine();
            String username = "HEBadmin";
            System.out.println("Enter password: ");
            //String password = scan.nextLine();
            String password = "admin";
            
            if(adminUsers.validateLogin(username, password)) {
                System.out.printf("\n== Welcome Administrator, %s! ==\n", username);
                me = allUsers.getUserByName(username);
                me.signIn();
                administratorFlow = true;
            } 
            else if(allUsers.validateLogin(username, password)){
                System.out.printf("\n== Welcome User, %s! ==\n", username);
                me = allUsers.getUserByName(username);
                me.signIn();
            }
            else{
                System.out.println("Invalid login\n");
            }
        }
        

        
        boolean quit = false;
        int choice = 0;

        if(administratorFlow){
            while(!quit) {
                printMainMenuAdmin();

                choice = scan.nextInt();
                scan.nextLine(); // Clear the linebreak from scanner
                if(choice < 1 || choice > 3) {
                    choice = 0;
                    System.out.println("Invalid choice");
                } else {
                    executeAdminMenu(scan, allLists, choice);
                }
            }  
        }
        
        else{
            while(!quit) {
                printMainMenu();

                choice = scan.nextInt();
                scan.nextLine(); // Clear the linebreak from scanner
                if(choice < 1 || choice > 3) {
                    choice = 0;
                    System.out.println("Invalid choice");
                } else {
                    executeMainMenu(scan, allLists, choice);
                }
            }   
        }

        scan.close();
    }
}