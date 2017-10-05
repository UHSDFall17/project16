

import java.util.Scanner;

	public class User {
		
		public static void Name(String userName) { 
			
			String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])).{8,}";
			
			while (userName.matches(userValidate) == false){
				System.out.println("Invalid username...please try again");
				Scanner create = new Scanner(System.in);
				userName = create.nextLine();
			}
			
	        
	    } 
		public static void Password(String userPassword) { 
			
			String userValidate = "((?=.*\\d)(?=.*[a-zA-Z])(?=.*[~'!@#$%?\\\\/&*\\]|\\[=()}\"{+_:;,.><'-])).{8,}";
			
			while (userPassword.matches(userValidate) == false){
				System.out.println("Invalid password...please try again");
				Scanner create = new Scanner(System.in);
				userPassword = create.nextLine();
			}
			
	        
	    } 

		public static void main(String[] args) {
			
			System.out.println("Please enter a user name:  ");
			System.out.println("Hint: Username must be of length 8 with both letters and numbers");
			Scanner create = new Scanner(System.in);
			String userName = create.nextLine();;
			Name(userName);
			
			System.out.println("Please enter a password:  ");
			System.out.println("Hint: Password must be of length 8 with both letter/s,special character/s, and number/s");
			String userPassword = create.nextLine();
			Password(userPassword);	
			
			System.out.println("Your Username is: " + userName);
			System.out.println("Your Password is: " + userPassword);
						
			return;
		}

}
