import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingListApp {
    private JFrame frame;
    private ArrayList<ShoppingList> lists;
    private User currentUser;

    public ShoppingListApp() {
        lists = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Shopping List App");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton createListButton = new JButton("Create New List");
        buttonPanel.add(createListButton);

        JButton editListButton = new JButton("Edit Existing List");
        buttonPanel.add(editListButton);

        JButton exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);

        createListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String listName = JOptionPane.showInputDialog(frame, "Enter name of new list:");
                if (listName != null && !listName.isEmpty()) {
                    newList(listName);
                    textArea.append("List \"" + listName + "\" has been created!\n\n");
                }
            }
        });

        editListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentUser == null) {
                    showLoginDialog();
                } else {
                    String[] listNames = getShoppingListNames();
                    if (listNames.length == 0) {
                        JOptionPane.showMessageDialog(frame, "No shopping lists available.");
                    } else {
                        String selectedListName = (String) JOptionPane.showInputDialog(frame,
                                "Choose a list to edit:", "Edit List", JOptionPane.QUESTION_MESSAGE, null,
                                listNames, listNames[0]);
                        if (selectedListName != null) {
                            ShoppingList selectedList = getShoppingListByName(selectedListName);
                            if (selectedList != null) {
                                editList(selectedList);
                            }
                        }
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
        showLoginDialog();
    }

    private void showLoginDialog() {
        String username = JOptionPane.showInputDialog(frame, "Enter username:");
        String password = JOptionPane.showInputDialog(frame, "Enter password:");

        // You can add your user authentication logic here
        // For simplicity, let's assume a hard-coded user for now
        if ("admin".equals(username) && "password".equals(password)) {
            currentUser = new User(username, password);
            frame.setTitle("Shopping List App - Logged in as: " + username);
            JOptionPane.showMessageDialog(frame, "Logged in as: " + username);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid login. Please try again.");
            currentUser = null;
            showLoginDialog(); // Retry login
        }
    }

    private String[] getShoppingListNames() {
        String[] listNames = new String[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            listNames[i] = lists.get(i).getName();
        }
        return listNames;
    }

    private ShoppingList getShoppingListByName(String name) {
        for (ShoppingList list : lists) {
            if (list.getName().equals(name)) {
                return list;
            }
        }
        return null;
    }

    private void newList(String listName) {
        ShoppingList newList = new ShoppingList(listName);
        lists.add(newList);
    }

    private void editList(ShoppingList list) {
        JFrame editFrame = new JFrame("Edit List: " + list.getName());
        editFrame.setBounds(100, 100, 400, 300);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.getContentPane().setLayout(new BorderLayout(0, 0));
    
        JTextArea listTextArea = new JTextArea();
        listTextArea.setEditable(false);
        JScrollPane listScrollPane = new JScrollPane(listTextArea);
        editFrame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
    
        JPanel editPanel = new JPanel();
        editFrame.getContentPane().add(editPanel, BorderLayout.SOUTH);
    
        JButton addItemButton = new JButton("Add Item");
        editPanel.add(addItemButton);
    
        JButton removeItemButton = new JButton("Remove Item");
        editPanel.add(removeItemButton);
    
        JButton viewListButton = new JButton("View List");
        editPanel.add(viewListButton);
    
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog(editFrame, "Enter item name:");
                if (itemName != null && !itemName.isEmpty()) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog(editFrame, "Enter quantity:"));
                    String category = JOptionPane.showInputDialog(editFrame, "Enter category:");
                    Item newItem = new Item(itemName, quantity, category);
                    list.addItem(newItem);
                    listTextArea.append("Added: " + newItem.getName() + " (Quantity: " + newItem.getQuantity() + ", Category: " + newItem.getCategory() + ")\n");
                }
            }
        });
    
        removeItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String removeName = JOptionPane.showInputDialog(editFrame, "Enter item name to remove:");
                Item itemToRemove = list.getItemByName(removeName);
                if (itemToRemove != null) {
                    list.removeItem(itemToRemove);
                    listTextArea.append("Removed: " + itemToRemove.getName() + "\n");
                } else {
                    JOptionPane.showMessageDialog(editFrame, "Item not found in the list.");
                }
            }
        });
        
        viewListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listTextArea.setText(""); // Clear the text area
                listTextArea.append("Shopping List: " + list.getName() + "\n");
                for (Item item : list.getItems()) { // Use getItems() method
                    listTextArea.append(item.getName() + " (Quantity: " + item.getQuantity() + ", Category: " + item.getCategory() + ")\n");
                }
            }
        });
    
        editFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingListApp();
            }
        });
    }
}
