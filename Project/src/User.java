import java.io.*;
import java.lang.*;
import java.util.Scanner;
import ProjectExceptions.*;
class User
{
	String username;
	String password;

	User()
	{}

	User(String username,  String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername()
	{
		return this.username;
	}

	void newUser()
	{
		try
		{
			File loginfile = new File("LoginFile\\loginfile.txt");
			FileWriter fw = new FileWriter(loginfile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			String s = this.username + " " + this.password;
			bw.write(s);
			bw.newLine();
			System.out.println("Login file updated sucessfully.");
			String userfilename = "UserList\\"+username+".txt";
			File f = new File(userfilename);
			f.createNewFile();
			System.out.println("Friend list file for user " + this.username + " created sucessfully!");
			bw.close();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	boolean login(String username, String password)
	{
		try
		{
			File f = new File("LoginFile\\loginfile.txt");
	    	FileReader fr = new FileReader(f);
	    	BufferedReader bin = new BufferedReader(fr);
			String sr = null;
			while((sr=bin.readLine())!=null)
			{
				String tokens[] = sr.split(" ");
				if(tokens[0].equals(username) && tokens[1].equals(password))
				return true;
			}
		bin.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	void menu() throws MaxFriendsException
	{
		try
		{
		int choice;
		System.out.println("Please select an operation from the menu:");
		FriendMenu f = new FriendMenu();
		System.out.println("Press 1 to add a friend"); 
		System.out.println("Press 2 to delete a friend"); 
		System.out.println("Press 3 to update info of a friend"); 
		System.out.println("Press 4 to exit");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch(choice)
		{
			case 1: f.add(this);
			System.out.println("\n");
		    menu();
			break;
			case 2: f.delete(this);
			System.out.println("\n");
			menu();
			break;	
			case 3: f.update(this);
			System.out.println("\n");
			menu();
			case 4: System.exit(0);
			default: System.out.println("Enter a valid choice.");
		}
	    }

	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}