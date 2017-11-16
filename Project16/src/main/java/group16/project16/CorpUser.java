package group16.project16;

/**
 * CorpUser = Corporate User, a user account associated with a corporation
 * CorpUser's will have access to features that normal User's do not, though
 * I am not sure what those are yet.
 * @author ryan
 */
public class CorpUser extends User {
    private Corporation myCorp;
    
    CorpUser(String newName, String newPassword, Corporation newCorp) {
        super(newName, newPassword);
        myCorp = newCorp;
    }
    
    
}
