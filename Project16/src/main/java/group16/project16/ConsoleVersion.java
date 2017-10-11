/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.project16;
import java.util.Scanner;
import java.io.*;
/**
 *  This program is used to test data structures and act as a stepping stone to
 *      the eventual GUI version.
 * @author ryan, justin, and chris
 */
public class ConsoleVersion {
    private static Scanner consoleIO = new Scanner(System.in);
    
    public static void main(String args[]) {
        // welcome
        printWelcome();
        // log in
        String username = User.loginSequence();
        if (username.equals("Invalid_Login")) {
            System.out.println("Unable to log in properly. Terminating program.");
            System.exit(0);
        }
        // load data
        Board rootBoard = null;             // rootBoard is the user's Board. Called 'root' for when we expand Board class to allow more Boards per user.
        if ((rootBoard = loadData(username)) != null) {
            // loaded data successfully :)
            // you can use Board rootBoard to navigate the user's Lists and subsequent Cards
            
        }
        else {
            // load unsuccessful :(
            System.out.println("");
        }
        // navigation menu with option to add/edit Cards and Lists. Also to include saveData() option once available.
        rootBoard.printBoard();
        //boardMenu();
        
        // exit sequence with option to saveData() 
        
    }
    
    public static void printWelcome() {
        System.out.println("*********************");
        System.out.println("Welcome to Project16!");
        System.out.println("*********************");
    }
    
    /*public static String loginSequence() {
        //for testing purposes, will be replaced with a password login with file verification
        //***We need to include a new user setup at login. 
        //   This should include creation of the user save file. 
        //   loadData() will not work if there is no user save file in the folder.
        
        return username;
    }*/
    
    public static Board loadData(String username) {
        // ***username should be of type User, probably
        // loadData() loads data from file "User.<username>.txt" located in the same folder as the app
        // ***Would be a good idea to save as not a .txt and also encryption, if time allows
        String userDataFile = "User.";
        userDataFile += username;
        userDataFile += ".txt";
        String nextLine = "";
        Board newBoard = null;
        List newList = null;
        Card newCard = null;
        
        try {
            FileReader fileReader = new FileReader(userDataFile);
            BufferedReader buffReader = new BufferedReader(fileReader);
            
            while((nextLine = buffReader.readLine()) != null) {
                if (nextLine.equals("%*%NEWBOARD%*%")) {
                    // assume we are dealing with a new Board
                    if ((nextLine = buffReader.readLine()) != null) {
                        newBoard = new Board(nextLine);
                        // TEST PRINT >>> DELETE BEFORE RELEASE <<<
                        //System.out.println("*NEW BOARD*");
                        //System.out.println(newBoard.getName());
                    }
                }
                else if (nextLine.equals("%*%NEWLIST%*%")) {
                    // assume we are dealing with a new List
                    if ((nextLine = buffReader.readLine()) != null) {
                        newList = new List(nextLine);
                        newBoard.addList(newList);
                        // TEST PRINT >>> DELETE BEFORE RELEASE <<<
                        //System.out.println("*NEW LIST*");
                        //System.out.println(newList.getName());
                    }
                }
                else {
                    // probably a Card
                    newCard = new Card(nextLine);
                    newList.addCard(newCard);
                    // TEST PRINT >>> DELETE BEFORE RELEASE <<<
                    //System.out.println("*NEW CARD*");
                    //System.out.println(newCard.getText());
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
        if (newBoard == null) {
            //no boards were found in the save file, so we need to create a blank one
            newBoard = new Board("First Board (default name)");
        }
        return newBoard;
    }
    
    /*public static boolean saveData(String username) {
        // userName should be of type User, probably
        // saves data to file named "User.<username>.txt"
        //***Should probably save to not a .txt and also encrypt
        // if successful, return true;
        // else, return false;
    }*/
}
