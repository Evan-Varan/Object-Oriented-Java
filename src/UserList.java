import java.util.HashSet;

/** Represents an list of users. Each user is of class "user".
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/
public class UserList {
    private HashSet<User> users;
    private final String INVALID = "INVALID";

    /**
     * Default constructor
     */
    public UserList() {
        users = new HashSet<User>();
    }

    /**
     * addUser
     * @param newUser adds this user to the users HashSet
     * @return a boolean value, true if it was succesfully added
     */
    public boolean addUser(User newUser) {
        return users.add(newUser);
    }

    /**
     * deleteUser
     * @param deleteUser removes this user from the users HashSet
     * @return a boolean value, true if successfully removed
     */
    public boolean deleteUser(User deleteUser) {
        return users.remove(deleteUser);
    }

    /**
     * listSize
     * @return the size of the users HashSet
     */
    public int listSize() {
        return users.size();
    }

    /**
     * checks if users HashSet has a specific user
     * @param aUser the user to check
     * @return a boolean value
     */
    public boolean hasUser(User aUser) {
        return users.contains(aUser);
    }

    /**
     * checks to see if login credentials are correct
     * @param username the username to check 
     * @param password the password to check
     * @return a boolean value. Login credentials are either correct or not.
     */
    public boolean validateLogin(String username, String password) {
        for(User i : users) {
            if (i.getUsername().equals(username)) {
                if (i.getPassword().equals(password)) {
                    i.signIn();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * prints out all users in the HashSet "users"
     */
    public void printUsers() {
        int counter = 1;
        for(User i : users) {
            System.out.printf("%d. Username: %s\n", counter, i.getUsername());
            ++counter;
        }
    }

    /**
     * finds a specific user by name
     * @param name the name of the user trying to be found
     * @return a user, either the user found or a dummy user
     */
    public User getUserByName(String name) {
        for(User i : users) {
            if(i.getUsername().equals(name)) {
                return i;
            }
        }

        // User was not found in list, so we are returning a dummy User
        User notFound = new User(INVALID, INVALID);
        return notFound;
    }

}