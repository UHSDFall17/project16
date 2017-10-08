
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

	public class User {
			
		public static String Name(String userName) { 
			@SuppressWarnings("resource")
			Scanner create = new Scanner(System.in);
			String userName1 = create.nextLine();
			String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
			while (userName1.matches(userValidate) == false){
				System.out.println("Invalid username...please try again");
				System.out.println("Please enter a user name:  ");
				System.out.println("Hint: Username must be of length 8 with both letters and numbers");
				userName1 = create.nextLine();
			}
			return userName1;
			
		}
		public static String userCheck(String userName) { 
			    File file = new File("C:\\Users\\ccupp\\Desktop\\test.txt");
			    Scanner scanner;
			    try {
			        scanner = new Scanner(file).useDelimiter( " ");
			        while (scanner.hasNext()) {
			            final String lineFromFile = scanner.nextLine();
			            if (lineFromFile.contains(userName)) {
			                System.out.println(userName + " is already in use, please try again");
			                System.out.println("Please enter a user name:  ");
			    			System.out.println("Hint: Username must be of length 8 with both letters and numbers");
			    			@SuppressWarnings("resource")
			    			Scanner create = new Scanner(System.in);
			    			userName = create.nextLine();
			    			String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
			    			while (userName.matches(userValidate) == false){
			    				System.out.println("Invalid username...please try again");
			    				System.out.println("Please enter a user name:  ");
			    				System.out.println("Hint: Username must be of length 8 with both letters and numbers");
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
			    }
			    return userName;
	    } 
		public static String Password(String userPassword) {
			@SuppressWarnings("resource")
			Scanner create = new Scanner(System.in);
			String userPassword2 = create.nextLine();
			
			String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[~'!@#$%?\\\\/&*\\]|\\[=()}\"{+_:;,.><'-])).{8,}";
			
			while (userPassword2.matches(userValidate) == false){
				System.out.println("Invalid password...please try again");
				System.out.println("Please enter a password:  ");
				System.out.println("Hint: Password must be of length 8 with both letter/s,special character/s, and number/s");
				userPassword2 = create.nextLine();
			}
			return userPassword2;
			
		} 
		private static final String FILENAME = "C:\\Users\\ccupp\\Desktop\\test.txt";

		public static void main(String[] args) {
			System.out.println("Please enter a user name:  ");
			System.out.println("Hint: Username must be of length 8 with both letters and numbers");
			String userName = Name(null);
			String userName2 = userCheck(userName);
			System.out.println("Please enter a password:  ");
			System.out.println("Hint: Password must be of length 8 with both letter/s,special character/s, and number/s");
			String userPassword = (null);
			String userPassword1 = Password(userPassword);	
			System.out.println("Your Username is: " + userName2);
			System.out.println("Your Password is: " + userPassword1);
			
			BufferedWriter bw = null;
			
			FileWriter fw = null;
				try {
					String content = userName2 + " " + userPassword;
					fw = new FileWriter(FILENAME,true);
					bw = new BufferedWriter(fw);
					bw.append(System.lineSeparator());
					bw.write(content);
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
