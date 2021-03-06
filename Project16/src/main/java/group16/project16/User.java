package group16.project16;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jasypt.util.text.BasicTextEncryptor;    // jasypt is an encryption/decryption library. Inluded in Maven dependencies.


public class User {
		
    private static String name;
    private static Board rootBoard;
    //private Corporation myCorp;
    private static User singleton = new User();
    private static final String FILENAME = "UsersData.txt"; // where User login data is stored
    private static final String encryptionKey = "totes1not2the3password";   // used with jasypt BasicTextEncryptor
    
    private User() {
        // using Singleton design pattern to allow only one User at a time (per instance of application)
        name = null;
        rootBoard = null;
        //this.myCorp = null;
    }
    
    public static User getUser() {
        return singleton;
    }
    
    public static String getUserName() {
        return name;
    }
    
    public static User UserFactory(boolean returnUser, String uName, String uPass) {
        if (name == null ) {                  // check if singleton is already populated, if not allow a login attempt
            String verifiedName = loginSequence(returnUser, uName, uPass);             // verifies User credentials and returns the User's name if legitimate
            if (!uName.equals("Invalid_Login")) {       // if we don't get an invalid login
                // login is valid, finish building instance of singleton User
                name = verifiedName;          // set the User's name
                singleton.loadData();                   // attempt to load data for that user
            }
        }
        // regardless of what happens above we want to return the value of singleton (null or a real User)
        return singleton;
    }
    
    public static void LogOutFactory(boolean saveBoards) {
        if (name != null && saveBoards) {
            singleton.saveData();           // save exiting User's data to their save file
        }
        name = null;          // set singleton.name null indicating it is empty
        rootBoard = null;     // set singleton.rootBoard null indicating it is empty
    }
    
    public static Board getRootBoard() {
        // Keep things simple. This method is sufficent.
        return rootBoard;
    }
    
    public void addBoard(Board newBoard) {
        try {
            if (rootBoard == null) {
                rootBoard = newBoard;
            }
            else {
                Board tempBoard = rootBoard;
                while (tempBoard.hasNext()) {
                    tempBoard = (Board)tempBoard.getNext();
                }
                // tempBoard is pointing to a board without a next
                tempBoard.setNext(newBoard);
            }
        }
        catch (NullPointerException e) {
            // This shouldn't happen but it probably will when we least expect it.
            // As a result of reaching an error, do nothing?
        }
    }
        
    public void removeBoard(Board oldBoard) {
        try {
            if (rootBoard.equals(oldBoard)) {
                rootBoard = (Board)rootBoard.getNext();
            }
            else {
                Board tempBoard = rootBoard;
                while (!((tempBoard.getNext()).equals(oldBoard))) {
                    if (tempBoard.hasNext()) {
                        tempBoard = (Board)tempBoard.getNext();
                    }
                    else {  // tempBoard does not have a next and oldBoard was not found
                        return;     // we have nothing to remove.
                    }
                }
                // tempBoard is pointing to oldBoard
                tempBoard = (Board)tempBoard.getPrev(); 
                tempBoard.setNext(tempBoard.getNext().getNext());
            }
        }
        catch (NullPointerException e) {
            // This shouldn't happen but it probably will when we least expect it.
            // As a result of reachig an error, do nothing?
        }
    }
    
/*    private static void userNameReq(){
            System.out.println("Please enter a user name:  ");
            System.out.println("Hint: Username must be of length 8 with both letters and numbers");
    }*/
    
/*    private static void passwordReq(){
            System.out.println("Please enter a password:  ");
            System.out.println("Hint: Password must be of length 8 with both letter/s,special character/s, and number/s");
    }*/
    
/*    private static String Name() { 
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
    }*/
    
    private static String newUserCheck(String userName) { 
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
        File file = new File("UsersData.txt");
	Scanner scanner;
	try {
	    scanner = new Scanner(file).useDelimiter(" ");
	    while (scanner.hasNext()) {
	        String lineFromFile = textEncryptor.decrypt(scanner.nextLine());   // deccrypt text from file
	        if (lineFromFile.contains(userName)) {
                    //System.out.println(userName + " is already in use, please try again");
	            //userNameReq();
                    //@SuppressWarnings("resource")
                    //Scanner create = new Scanner(System.in);
                    userName = userName + "1";//create.nextLine();
                    /*String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
                    while (userName.matches(userValidate) == false){
			//System.out.println("Invalid username...please try again");
			//userNameReq();
                        @SuppressWarnings("resource")
			Scanner create1 = new Scanner(System.in);
			userName = create1.nextLine();
                    }*/
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

    private static boolean userCheck(String userName, String password) { 
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
        File file = new File("UsersData.txt");
	Scanner fscanner;
	try {
            //int tries = 0;
            //while (tries++ < 3) {
                fscanner = new Scanner(file);//.useDelimiter(" ");
                while (fscanner.hasNext()) {
                    String lineFromFile = fscanner.next();   // deccrypt text from file
                    String decryptedLine = textEncryptor.decrypt(lineFromFile);
                    String[] splitLine = decryptedLine.split("\\s+");
                    if (splitLine[0].equals(userName)) {
                        // check if password matches found username
                        if (splitLine[1].equals(password)) {
                            // we have a match!
                            return true;
                        }
                    }
                }
                //System.out.println("Username and Password do not match! Please try again.");
                //userNameReq();
                //userName = Name();
                //passwordReq();
                //password = Password();
            //}
            //System.out.println("Too many failed attempts!!! Terminating program...");
            //System.exit(0);
        } 
	catch (IOException e) {
            // ???
        }
	return false;
    } 
    
/*    private static String Password() {		
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
    }*/
    
    private static String loginSequence(boolean returnUser, String uName, String uPass) {
        //@SuppressWarnings("resource")
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
	//Scanner loginScanner = new Scanner(System.in);
        //System.out.println("Are you a returning user? (Y/n): ");
        //String response = loginScanner.nextLine();
        if (!returnUser /*response.equalsIgnoreCase("n")*/) {
            // new user login sequence (set up new user)
            //userNameReq();
            String userName = uName;   //Name();
            String userName2 = newUserCheck(userName);
            //passwordReq();
            String userPassword = uPass;    //Password();
            // now write the new user info to the UsersData file
            BufferedWriter bw = null;
            FileWriter fw = null;
            try {
                String content = userName2 + " " + userPassword;
                String contentEncrypt = textEncryptor.encrypt(content);
                fw = new FileWriter(FILENAME,true);
                bw = new BufferedWriter(fw);
                bw.append(System.lineSeparator());
                bw.write(contentEncrypt);
                //System.out.println("User addded successfully!");
                //System.out.println("You are now logged in");
                // also need to create a save file for the new user
                try {
                    String saveFileName = "User." + userName + ".txt";
                    File file = new File(saveFileName);
                    FileWriter saveFile;
                    saveFile = new FileWriter(file);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
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
        else if (returnUser /*response.equalsIgnoreCase("y")*/) {
            // returning user login sequence
            //userNameReq();
            String userName = uName;  //Name();
            //passwordReq();
            String userPassword = uPass;      //Password();
            if (userCheck(userName, userPassword)) {
                // if true we have a valid login
                //System.out.println("Successful Login!!!");
                return userName;
            } 
            else {
                //System.out.println("Unsuccessful login... :(");
            }
        }
        else {
            // unexpected response
            //System.out.println("Unexpected response... Please try again.");
        }
		
        // if we reached this point, something didn't work
        return "Invalid_Login";
    }
    
    private void loadData() {
        // loadData() loads data from file "User.<username>.txt" located in the same folder as the app
        // loadData() is not static despite use of Singleton because rootBoard belongs to an individual
        // and not the class. When a User logs out we can set singleton = null instead of deleting 
        // all the loaded Boards.
        // ***Would be a good idea to encrypt on save and decrypt on load, if time allows
        String userDataFile = "User.";
        userDataFile += this.name;
        userDataFile += ".txt";
        String nextEncrypt = "";
        Board currBoard = null;
        List currList = null;
        Card currCard = null;
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
        String nextDecrypt = "";
        try {
            FileReader fileReader = new FileReader(userDataFile);
            BufferedReader buffReader = new BufferedReader(fileReader);
            while((nextEncrypt = buffReader.readLine()) != null) {
                nextDecrypt = textEncryptor.decrypt(nextEncrypt);
                switch (nextDecrypt) {
                    case "%*%NEWBOARD%*%":
                        // assume we are dealing with a new Board
                        if ((nextEncrypt = buffReader.readLine()) != null) {
                            nextDecrypt = textEncryptor.decrypt(nextEncrypt);
                            currBoard = new Board(nextDecrypt);
                            this.addBoard(currBoard);           // add this Board to the User
                        }
                        break;
                    case "%*%NEWLIST%*%":
                        // assume we are dealing with a new List
                        if ((nextEncrypt = buffReader.readLine()) != null) {
                            nextDecrypt = textEncryptor.decrypt(nextEncrypt);
                            currList = new List(nextDecrypt);
                            if (currBoard != null) {
                                currBoard.addList(currList);
                            }
                            else {
                                // there is no board to add this to. What do?
                            }
                        }
                        break;
                    default:
                        // probably a Card
                        nextDecrypt = textEncryptor.decrypt(nextEncrypt);
                        currCard = new Card(nextDecrypt);
                        if (currBoard != null && currList != null) {
                            currList.addCard(currCard);
                        }
                        else {
                            // there is no board/list to add this to. What do?
                        } 
                        break;
                }
            }
            buffReader.close();
        }  
        catch(FileNotFoundException ex) {
            // no save file found for User so create a new one 
            try {
                    String saveFileName = "User." + this.name + ".txt";
                    File file = new File(saveFileName);
                    FileWriter saveFile;
                    saveFile = new FileWriter(file);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    //no boards were found in the save file, so we need to create a blank one
                    currBoard = new Board("First Board (default name)");
                    this.addBoard(currBoard);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ userDataFile + "'");                  
            // Or we could just do this: 
            ex.printStackTrace();
        }
        if (currBoard == null) {
            //no boards were found in the save file, so we need to create a blank one
            currBoard = new Board("First Board (default name)");
            this.addBoard(currBoard);
        }
    }
    

    private void saveData() {
        // Save the data for this User.
        // saveData() saves data to file "User.<username>.txt" located in the same folder as the app
        // saveData() is not static despite use of Singleton because rootBoard belongs to an individual
        // and not the class. When a User logs out we can set singleton = null instead of deleting 
        // all the loaded Boards.
        // ***Would be a good idea to encrypt on save and decrypt on load, if time allows
        String userDataFile = "User.";
        userDataFile += this.name;
        userDataFile += ".txt";
        String nextLine = "";
        Board currBoard = null;
        List currList = null;
        Card currCard = null;
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(encryptionKey);
        String myEncryptedText = "";    //textEncryptor.encrypt(myText);
                
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(userDataFile);    // we want to overwrite what is there with what now exists
            bw = new BufferedWriter(fw);
            // write everything to file, encrypted
            currBoard = rootBoard;
            while (currBoard != null) {     // walk through Boards for this User 
                nextLine = "%*%NEWBOARD%*%";
                myEncryptedText = textEncryptor.encrypt(nextLine);
                bw.write(myEncryptedText);
                bw.newLine();
                nextLine = currBoard.getName();
                myEncryptedText = textEncryptor.encrypt(nextLine);
                bw.write(myEncryptedText);
                bw.newLine();
                currList = currBoard.getHead();
                while (currList != null) {  // walk through Lists for this Board
                    nextLine = "%*%NEWLIST%*%";
                    myEncryptedText = textEncryptor.encrypt(nextLine);
                    bw.write(myEncryptedText);
                    bw.newLine();
                    nextLine = currList.getName();
                    myEncryptedText = textEncryptor.encrypt(nextLine);
                    bw.write(myEncryptedText);
                    bw.newLine();
                    currCard = currList.getHead();
                    while (currCard != null) {      // walk through Cards for this List
                        nextLine = currCard.getText();
                        myEncryptedText = textEncryptor.encrypt(nextLine);
                        bw.write(myEncryptedText);
                        bw.newLine();
                        currCard = (Card)currCard.getNext();
                    }
                    currList = (List)currList.getNext();
                }
                currBoard = (Board)currBoard.getNext();
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
}
