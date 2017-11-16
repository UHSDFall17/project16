package group16.project16;

/**
 *  Corporation class to represent corporations we do business with.
 *  In other words these are the paying customers. A corporation will pay for 
 *  premium access and all users associated with them will have CorpUser accounts.
 * 
 * @author ryan
 */
public class Corporation {
    private String name;
    private String password;
    private boolean isPremium;
    
    Corporation() {
        name = null;
        password = null;
        isPremium = false;
    }
    
    boolean premiumStatus() {
        return this.isPremium;
    }
    
    void setPremium() {
        this.isPremium = true;
    }
    
    void revokePremium() {
        this.isPremium = false;
    }
    
    boolean changePassword(String oldPassProvided, String newPassword) {
        if (oldPassProvided.equals(this.password)) {
            this.password = newPassword;
            return true;
        }
        else
            return false;
    }
    
    boolean verifyPassword(String passProvided) {
        // like logging in. See if the password provided matches the one for this user. Maybe include a counter to prevent too many attempts?
        if (passProvided.equals(this.password)) 
            return true;
        else
            return false;
    }
    
}
