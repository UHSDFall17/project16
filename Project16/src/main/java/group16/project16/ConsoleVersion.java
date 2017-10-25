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
 * @author ryan, zengye, and chris
 */
public class ConsoleVersion {
    //private static Scanner consoleIO = new Scanner(System.in);
    
    public static void main(String args[]) {
        // welcome
        printWelcome();
        // log in
        String userName = User.loginSequence();
        if (userName.equals("Invalid_Login")) {
            System.out.println("Unable to log in properly. Terminating program.");
            System.exit(0);
        }
        // load data
        Board rootBoard = null;             // rootBoard is the user's Board. Called 'root' for when we expand Board class to allow more Boards per user.
        if ((rootBoard = loadData(userName)) == null) {
            // unsuccessful load, exit
            System.out.println("Load unsuccessful... Goodbye.");
            System.exit(0);
        }
        // navigation menu with option to add/edit Cards and Lists. Also to include saveData() option once available.
        navigationMenu(rootBoard);
        
        // exit sequence with option to saveData() 
        exitSequence(userName);
    }
    
    private static void printWelcome() {
        System.out.println("*********************");
        System.out.println("Welcome to Project16!");
        System.out.println("*********************");
    }
    
    private static Board loadData(String username) {
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
                    }
                }
                else if (nextLine.equals("%*%NEWLIST%*%")) {
                    // assume we are dealing with a new List
                    if ((nextLine = buffReader.readLine()) != null) {
                        newList = new List(nextLine);
                        newBoard.addList(newList);
                    }
                }
                else {
                    // probably a Card
                    newCard = new Card(nextLine);
                    newList.addCard(newCard);
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
    
    private static boolean saveData(String username) {
        // userName should be of type User, probably
        // saves data to file named "User.<username>.txt"
        //***Should probably save to not a .txt and also encrypt
        // if successful, return true;
        // else, 
        return false;
    }
    
    private static void navigationMenu(Board rootBoard) {
        // print user's Board
        // ask user what they want to do next
    }
    
    private static void exitSequence(String userName) {
        // offer to save work before exiting
        System.out.println("Would you like to save your work before exitting?");
        // if yes, saveData(userName);
        // else, continue...
        // say good bye and shut things down
    }
}
