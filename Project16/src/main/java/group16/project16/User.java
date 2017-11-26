package group16.project16;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class User {
		
    private String name;
    private String password;
    private Board rootBoard;    // root Board belonging to each User. It points to other Boards belonging to the User.
    
    User(String newName, String newPassword) {
        // a new User may not be created without a username and password
        this.name = newName;
        this.password = newPassword;
        this.rootBoard = null;
    }
    
    Board getRootBoard() {
        // Keep things simple. This method is sufficent.
        return this.rootBoard;
    }
    
    void addBoard(Board newBoard) {
        try {
            if (this.rootBoard == null) {
                this.rootBoard = newBoard;
            }
            else {
                Board tempBoard = this.rootBoard;
                while (tempBoard.hasNext()) {
                    tempBoard = (Board)tempBoard.getNext();
                }
                // tempBoard is pointing to a board without a next
                tempBoard.setNext(newBoard);
            }
        }
        catch (NullPointerException e) {
            
        }
    }
        
    void removeBoard(Board oldBoard) {
        if (this.rootBoard.equals(oldBoard)) {
            this.rootBoard = (Board)this.rootBoard.getNext();
        }
        else {
            Board tempBoard = this.rootBoard;
            while (!((tempBoard.getNext()).equals(oldBoard))) {
                if (tempBoard.hasNext()) {
                    tempBoard = (Board)tempBoard.getNext();
                }
                else {  // tempBoard does not have a next and oldBoard was not found
                    return;     // do nothing more
                }
            }
            // tempBoard is pointing to oldBoard
            tempBoard = (Board)tempBoard.getPrev(); 
            tempBoard.setNext(tempBoard.getNext().getNext());
        }
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
    
    public static void userNameReq(){
            System.out.println("Please enter a user name:  ");
            System.out.println("Hint: Username must be of length 8 with both letters and numbers");
    }
    public static void passwordReq(){
            System.out.println("Please enter a password:  ");
            System.out.println("Hint: Password must be of length 8 with both letter/s,special character/s, and number/s");
    }
    public static String Name() { 
	@SuppressWarnings("resource")
	Scanner create = new Scanner(System.in);
	String userName1 = create.nextLine();
	String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
	while (userName1.matches(userValidate) == false){
            System.out.println("Invalid username...please try again");
            userNameReq();
            userName1 = create.nextLine();
            userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
	}
	return userName1;		
    }
    
    public static String newUserCheck(String userName) { 
        File file = new File("UsersData.txt");
	Scanner scanner;
	try {
	    scanner = new Scanner(file).useDelimiter( " ");
	    while (scanner.hasNext()) {
	        final String lineFromFile = scanner.nextLine();
	        if (lineFromFile.contains(userName)) {
                    System.out.println(userName + " is already in use, please try again");
	            userNameReq();
                    @SuppressWarnings("resource")
                    Scanner create = new Scanner(System.in);
                    userName = create.nextLine();
                    String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
                    while (userName.matches(userValidate) == false){
			System.out.println("Invalid username...please try again");
			userNameReq();
                        @SuppressWarnings("resource")
			Scanner create1 = new Scanner(System.in);
			userName = create1.nextLine();
                    }
		}
		else{
		
                }	
            }
        } 
	catch (IOException e) {
            // ???
        }
	return userName;
    } 

    public static boolean userCheck(String userName, String password) { 
    File file = new File("UsersData.txt");
	Scanner fscanner;
	try {
            int tries = 0;
            while (tries++ < 3) {
                fscanner = new Scanner(file).useDelimiter(" ");
                while (fscanner.hasNext()) {
                    final String lineFromFile = fscanner.nextLine();
                    String[] splitLine = lineFromFile.split("\\s+");
                    if (splitLine[0].equals(userName)) {
                        // check if password matches found username
                        if (splitLine[1].equals(password)) {
                            // we have a match!
                            return true;
                        }
                    }
                }
                System.out.println("Username and Password do not match! Please try again.");
                userNameReq();
                userName = Name();
                passwordReq();
                password = Password();
            }
            System.out.println("Too many failed attempts!!! Terminating program...");
            System.exit(0);
        } 
	catch (IOException e) {
            // ???
        }
	return false;
    } 
    
    public static String Password() {		
        @SuppressWarnings("resource")
	Scanner create = new Scanner(System.in);
	String userPassword2 = create.nextLine();
	String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[~'!@#$%?\\\\/&*\\]|\\[=()}\"{+_:;,.><'-])).{8,}";
			
	while (userPassword2.matches(userValidate) == false){
            System.out.println("Invalid password...please try again");
            passwordReq();
            userPassword2 = create.nextLine();
	}
	return userPassword2;	
    }
    
    private static final String FILENAME = "UsersData.txt";
    
    public static String loginSequence() {
        @SuppressWarnings("resource")
	Scanner loginScanner = new Scanner(System.in);
        System.out.println("Are you a returning user? (Y/n): ");
        String response = loginScanner.nextLine();
        if (response.equalsIgnoreCase("n")) {
            // new user login sequence (set up new user)
            userNameReq();
            String userName = Name();
            String userName2 = newUserCheck(userName);
            passwordReq();
            String userPassword = Password();
            
            // now write the new user info to the UsersData file
            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                String content = userName2 + " " + userPassword;
                fw = new FileWriter(FILENAME,true);
                bw = new BufferedWriter(fw);
                bw.append(System.lineSeparator());
                bw.write(content);
                System.out.println("User addded successfully!");
                System.out.println("You are now logged in");
                // also need to create a save file for the new user
                try {
                    String saveFileName = "User." + userName + ".txt";
                    File file = new File(saveFileName);
                    FileWriter saveFile;
                    saveFile = new FileWriter(file);
                    return userName;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            } 
            finally {
                try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } 
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }   
        }
        else if (response.equalsIgnoreCase("y")) {
            // returning user login sequence
            userNameReq();
            String userName = Name();
            passwordReq();
            String userPassword = Password();
            if (userCheck(userName, userPassword)) {
                // if true we have a valid login
                System.out.println("Successful Login!!!");
                return userName;
            } 
            else {
                System.out.println("Unsuccessful login... :(");
            }
        }
        else {
            // unexpected response
            System.out.println("Unexpected response... Please try again.");
        }
		
        // if we reached this point, something didn't work
        return "Invalid_Login";
    }
    
    void loadData() {
        // loadData() loads data from file "User.<username>.txt" located in the same folder as the app
        // ***Would be a good idea to save as not a .txt and also encryption, if time allows
        String userDataFile = "User.";
        userDataFile += this.name;
        userDataFile += ".txt";
        String nextLine = "";
        Board currBoard = null;
        List currList = null;
        Card currCard = null;
        
        try {
            FileReader fileReader = new FileReader(userDataFile);
            BufferedReader buffReader = new BufferedReader(fileReader);
            
            while((nextLine = buffReader.readLine()) != null) {
                if (nextLine.equals("%*%NEWBOARD%*%")) {
                    // assume we are dealing with a new Board
                    if ((nextLine = buffReader.readLine()) != null) {
                        currBoard = new Board(nextLine);
                        this.addBoard(currBoard);
                    }
                }
                else if (nextLine.equals("%*%NEWLIST%*%")) {
                    // assume we are dealing with a new List
                    if ((nextLine = buffReader.readLine()) != null) {
                        currList = new List(nextLine);
                        if (currBoard != null) {
                            currBoard.addList(currList);
                        }
                        else {
                            // there is no board to add this to. What do?
                        }
                    }
                }
                else {
                    // probably a Card
                    currCard = new Card(nextLine);
                    if (currBoard != null && currList != null) {
                            currList.addCard(currCard);
                        }
                        else {
                            // there is no board/list to add this to. What do?
                        }                   
                }
            }
            buffReader.close();
        }  
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + userDataFile + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ userDataFile + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        if (currBoard == null) {
            //no boards were found in the save file, so we need to create a blank one
            currBoard = new Board("First Board (default name)");
            this.addBoard(currBoard);
        }
    }
    
}
