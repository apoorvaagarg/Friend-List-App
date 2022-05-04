import java.io.*;
import ProjectExceptions.*;
import java.util.Scanner;
class FriendMenu
{

	String name, address, dob; 
	int contact;

	int checkfriends(User u) throws IOException
	{
		int count = 0;
		String filename = "UserList\\"+u.getUsername()+".txt";
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String sr;
		while((sr = br.readLine())!= null)
		{
			if(sr.equals(""))
			{
			continue;
			}
			else
			{
			count++;
			}
		}
		return count; 
	}

	int checkmaxfriends() throws IOException
	{
		int max = 0;
		String properties = "PropertiesFile\\maxfriends.txt";
		FileReader fr = new FileReader(properties);
		BufferedReader br = new BufferedReader(fr);
		String s;
		while((s = br.readLine())!=null)
		{
			String tokens[] = s.split("");
			max = Integer.parseInt(tokens[0]);
		}
		return max;
	}

	void add(User u) throws MaxFriendsException, IOException
	{
		int check = checkfriends(u);
		int max = checkmaxfriends();
		System.out.println("You have " + check + " friends in your list.");
		System.out.println("Max friends allowed are " + max);
		if((check+1)<=max)
		{
			System.out.println("A friend is going to be added in file of user " +u.getUsername());
			String file = "UserList\\"+u.getUsername()+".txt";
			File f = new File(file);
			FileWriter fout = new FileWriter(f,true);
			BufferedWriter bout = new BufferedWriter(fout);
			Scanner sca = new Scanner(System.in);
			System.out.println("Enter name of the friend");
			this.name = sca.next();
			System.out.println("Enter phone no. of the friend");
			this.contact = sca.nextInt();
			System.out.println("Enter address");
			this.address = sca.next();
			System.out.println("Enter date of birth");
			this.dob = sca.next();
			String sr = this.name +", " + this.contact + ", " + this.address + ", " + this.dob;
			bout.write(sr);
			bout.newLine();
			bout.close();
			System.out.println("New friend added");
		}
		else
		{
			throw new MaxFriendsException("You cannot add new friends.");
		}
	}

	void delete(User u) throws IOException
	{
		int check = checkfriends(u);
		System.out.println("You have " + check + " friends in your list.");
        File f = null;
		try
        {
           f = new File("UserList\\"+u.getUsername()+".txt");
           Scanner s = new Scanner(System.in);
           String sr;
           boolean flag = true;
           FileReader fin = new FileReader(f);
           BufferedReader bin = new BufferedReader(fin);
           int i = 1;
           while((sr = bin.readLine())!=null&&flag)
           {
           	 if(sr.equals(""))
			{
			continue;
			}
			else
			{
			System.out.println(i++ + " - " + sr);
			}
           }
           bin.close();
      
        }

        catch(Exception e)
        {
           e.printStackTrace();
        }

           Scanner s = new Scanner(System.in);
           f = new File("UserList\\"+u.getUsername()+".txt");
           StringBuffer sb = new StringBuffer();
           FileReader fr = new FileReader(f);
           BufferedReader br = new BufferedReader(fr);
           System.out.println("enter the serial no. of the friend to be deleted");
           int inputline = s.nextInt();
           int lines = 1;
           String str;
           while((str = br.readLine())!=null)
           { 
           	if(str.equals(""))
			{
			continue;
			}
			else
			{
			if(lines==inputline)
           {
            break;
           }
            lines++;
			}
           
           }

			
			BufferedReader bin = null;
			FileWriter fw = null;
			
			try
			{
				bin = new BufferedReader(new FileReader(f));
                 String line = "";
                 String oldcontent = "";
                while((line = bin.readLine()) != null )
                 {

                 oldcontent += line + "\r\n";
                 }
                 bin.close();

				String newcontent = oldcontent.replaceAll(str, "");
				fw = new FileWriter(f);
				fw.write(newcontent);
				fw.close();
			}

			catch(IOException e)
			{
				e.printStackTrace();
			}

			System.out.println("friend successfully deleted");

		} 

		void update(User u) throws IOException
	    {
		int check = checkfriends(u);
		System.out.println("You have " + check + " friends in your list.");
        File f = null;
		try
        {
           f = new File("UserList\\"+u.getUsername()+".txt");
           Scanner s = new Scanner(System.in);
           String sr;
           boolean flag = true;
           FileReader fin = new FileReader(f);
           BufferedReader bin = new BufferedReader(fin);
           int i = 1;
           while((sr = bin.readLine())!=null&&flag)
           {
           	 if(sr.equals(""))
			{
			continue;
			}
			else
			{
			System.out.println(i++ + " - " + sr);
			}
           }
           bin.close();
      
        }

        catch(Exception e)
        {
           e.printStackTrace();
        }

           Scanner s = new Scanner(System.in);
           f = new File("UserList\\"+u.getUsername()+".txt");
           StringBuffer sb = new StringBuffer();
           FileReader fr = new FileReader(f);
           BufferedReader br = new BufferedReader(fr);
           System.out.println("enter the serial no. of the friend to update info");
           int inputline = s.nextInt();
           s.nextLine();
           int lines = 1;
           String str;
           while((str = br.readLine())!=null)
           { 
           	if(str.equals(""))
			{
			continue;
			}
			else
			{
			if(lines==inputline)
           {
            break;
           }
            lines++;
			}  
           }

			
			
			
			System.out.println("enter new name, contact, address, date of birth");
			String newinfo = s.nextLine();

			BufferedReader bin = null;
			FileWriter fw = null;
			
			try
			{
				
				bin = new BufferedReader(new FileReader(f));
                 String line = "";
                 String oldcontent = "";
                while((line = bin.readLine()) != null )
                 {

                 oldcontent += line + "\r\n";
                 }
                 bin.close();



				String newcontent = oldcontent.replaceAll(str, newinfo);
				fw = new FileWriter(f);
				fw.write(newcontent);
				fw.close();
			}

			catch(IOException e)
			{
				e.printStackTrace();
			}

			System.out.println("friend info updated successfully");

		}
	}