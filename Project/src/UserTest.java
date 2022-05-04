import java.util.Scanner;
import ProjectExceptions.*;
class UserTest
{
	public static void main(String args[])
	{
		String id, pass;
		boolean b; 
	    Scanner s = new Scanner(System.in);
	    System.out.print("Enter Username: ");
	    id = s.next();
	    System.out.print("Enter Password: ");
	    pass = s.next();
	    User u = new User(id, pass);
	    b = u.login(id, pass);
	    if(b == false)
	    {
	    	try
	    	{
	    		throw new UnregisteredException("You are not a registered user of our app. Please register yourself to proceed.");
	    	}
	    	catch(UnregisteredException e)
	    	{
	    		System.out.println(e);
	    	}
	    	System.out.println("Enter Username");
	    	id = s.next();
	    	System.out.print("Enter Password:");
	    	pass = s.next();
	    	User nu = new User(id,pass);
	    	nu.newUser();
	    }
	    
	    else
	    {
	    	try
	    	{
	    		System.out.println("You are a registered User of our app.");
	    		u.menu();
	    	}
	    	catch(MaxFriendsException e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	    }

	}
}