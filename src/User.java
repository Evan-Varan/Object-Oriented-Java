/** Represents an user of software, where each user has a username and password.
 * @author James Hardy
 * @author Evan Varan
 * @version 1.0
*/
public class User {
    private String username;
    private String password;
    private boolean signedIn;

    /**
     * Default constructor
     */
    public User() {
        username = "username";
        password = "password";
        signedIn = false;
    }

    /**
     * Parameterized Constructor
     * @param newUsername the new value for this.username
     * @param newPassword the new value for this.password
     */
    public User(String newUsername, String newPassword) {
        username = newUsername;
        password = newPassword;
        signedIn = false;
    }

    /**
     * Store mutator
     * @param newUsername the new value for this.username
     */
    public void setUsername(String newUsername) {
        username = newUsername;
    }

    /**
     * Store mutator
     * @param newPassword the new value for this.password
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    /**
     * If boolean signedIn is false, set it to true.
     */
    public void signIn() {
        if (!signedIn) {
            signedIn = true;
        }
    }

    /**
     * If boolean signedIn is true, set it to false.
     */
    public void signOut() {
        if (signedIn) {
            signedIn = false;
        }
    }

    /**
     * Username accessor
     * @return the private username variable
     */
    public String getUsername() {
        return username;
    }

    /**
     * Password accessor
     * @return the private password variable
     */
    public String getPassword() {
        return password;
    }

    /**
     * signedIn accessor
     * @return the private signedIn variable
     */
    public boolean isSignedIn() {
        return signedIn;
    }
}