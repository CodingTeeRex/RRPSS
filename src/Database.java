package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	//List to store all the existing employee of the restaurant from a given .csv file
	static List<Person> employeesDB = new ArrayList<Person>();
	//List to store all the existing customer that visited the restaurant from a given .csv file
	static List<Person> customersDB = new ArrayList<Person>();
	//List to store all the existing menuItems that are available in the restaurant from a given .csv file
	static List<MenuItem> menuItemsDB = new ArrayList<MenuItem>();

	//Enum for easy access to the valid index for respective attributes from the csv
	static enum DesiredAttribute
	{
		//Person Attributes
		FIRSTNAME ("FirstName" , 0),
		LASTNAME ("LastName", 0),
		GENDER ("Gender" , 0),
		CONTACT ("Contact", 0),
		TITLE ("Title" , 0),
		ID ("Id", 0),
		MEMEBERTYPE ("Member", 0),
		//MenuItem Attributes
		ITEMNAME ("ItemName" , 0),
		ITEMDESCRIPTION ("ItemDesc", 0),
		ITEMTYPE ("ItemType", 0),
		ITEMPRICE ("ItemPrice", 0);

		//Obtaining all the attributes initialised in DesiredAttribute
		static DesiredAttribute[] desired = DesiredAttribute.values();
		//Name of the DesiredAttribute
		private String name;
		//Index of the DesiredAttribute
		private int index;
		//Obtaining the name of the DesireAttribute
		public String getName(){ return this.name; }
		//Obtaining the index of the DesireAttribute
		public int getIndex(){ return this.index; }
		//Setting the index of the DesireAttribute
		public void setIndex(int index) { this.index = index; }
		//Setting the index of the DesireAttribute based of the name provided
		public static void setIndex(String name, int index)
		{
			for (DesiredAttribute d : desired)
			{
				if(name.contains(d.getName()))
				{
					d.setIndex(index);
				}
			}
		}
		//Printing the desiredAttributes available
		public static void print()
		{
			
			for (DesiredAttribute d : desired)
			{
				System.out.println(d.getName() + d.getIndex());
			}
		}
		//Constructor for the DesiredAttribute
		DesiredAttribute(String name, int index)
		{
			this.name = name;
		}
	}
	//CAN BE REMOVED
	public static void main(String[] args) 
	{
		parseCSV("src");
		//printDatabase();
	}
	//Obtaining all the csv files in the folder path provided
	public static void parseCSV(String folderPath)
	{
		//Obtaining the folder using the path provided
		File folder = new File(folderPath);
		//Obtaining the files in the respective folder
		File[] listOfFiles = folder.listFiles();

		//Traverse the file and search for .csv files only
		for (File file : listOfFiles) {
		    if (file.isFile() && file.getName().contains(".csv")) {
		        //System.out.println(file.getName());
		        //System.out.println(file.getAbsolutePath());

				//Convert .csv to respective Java classes
		        parseData(file.getAbsolutePath(), file.getName());
		    }
		}
	}
	//Converting the data from the csv files into useable classes in Java via path
	public static void parseData(String path, String type)
	{
			//File path
			String file = path;	
			
			//Used for reading file
			BufferedReader reader = null;
			
			//Current Line traversed
			String line = "";
			
			//Try to read the file
			try 
			{
				//Reader used for reading the csv
				reader = new BufferedReader(new FileReader(file));

				//If the .csv file name contains the word Person, it is associated with crafting the Customer/Employee Database
				if (type.contains("Person"))
				{	
					//Reading the first line to obtain attribute from csv
					line = reader.readLine();
					String[] attributes = line.split(",");
					
					//Setting the DesiredAttributes with the valid index for obtaining the attributes from the line later
					for (int i = 0; i < attributes.length; i++ )
					{
						DesiredAttribute.setIndex(attributes[i], i);
					}
					//Read the entire .csv file
					while ((line = reader.readLine()) != null)
					{
						//Splitting the lines into respective attributes for constructing classes
						String[] personRow = line.split(",");
						
						//The person does not have an ID, hence is a customer
						if (personRow[DesiredAttribute.ID.getIndex()].equals("NA"))
						{
							//Construct the customer 
							customersDB.add(InitialiseCustomer(personRow));
						}
						//The person has an ID, hence is an employee
						else
						{
							//Construct the employee
							employeesDB.add(InitialiseEmployee(personRow));
						}						
					}
				}
				//If the .csv file name contains the word Item, it is associated with crafting the MenuItem Database
				else if (type.contains("Item"))
				{
					//Reading the first line to obtain attribute from csv
					line = reader.readLine();
					String[] row = line.split(",");
					//Setting the DesiredAttributes with the valid index for obtaining the attributes from the line later
					for (int i = 0; i < row.length; i++ )
					{
						DesiredAttribute.setIndex(row[i], i);
					}
					//Read the entire .csv file
					while ((line = reader.readLine()) != null)
					{
						//Splitting the lines into respective attributes for constructing classes
						String[] itemRow = line.split(",");
						
						//Construct the menuItem
						menuItemsDB.add(InitialiseMenuItem(itemRow));
					}
				}
				//Since there is only 3 csv in the folder, the remaining file is for obtaining Titles available in the restaurant
				else
				{
					//Read the entire .csv file
					while ((line = reader.readLine()) != null)
					{
						//Adding the available titles of the restaurant into the list
						Employee.getTitleList(false).add(line.replaceAll("[^a-zA-Z/ ]", "").trim());
					}
				}
				
						
			}
			//Display Error
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//Close the reader after finished
			finally
			{
				try {
					reader.close();
				} catch (IOException e) {
					//Display Error is unable to close Reader
					e.printStackTrace();
				}
			}
			
			
	}
	//Constructing the Customer for adding into the database
	public static Customer InitialiseCustomer(String[] row)
	{
		//Obtaining the respective attributes using the DesiredAttribute for accuracy
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		String member = row[DesiredAttribute.MEMEBERTYPE.getIndex()];
		
		//Construct the Customer
		Customer c = new Customer(firstName, lastName, gender, contactNumber, member);
		//Return the constructed Customer
		return c;
	}
	//Constructing the Employee for adding into the database
	public static Employee InitialiseEmployee(String[] row)
	{
		//Obtaining the respective attributes using the DesiredAttribute for accuracy
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		int id = Integer.valueOf(row[DesiredAttribute.ID.getIndex()]);
		String title = row[DesiredAttribute.TITLE.getIndex()];
		
		//Construct the Employee
		Employee e = new Employee(firstName, lastName, gender, contactNumber, id, title);
		//Return the constructed Employee
		return e;
	}
	//Constructing the Menu Item for adding into the database
	public static MenuItem InitialiseMenuItem(String[] row)
	{
		//Obtaining the respective attributes using the DesiredAttribute for accuracy
		String name = row[DesiredAttribute.ITEMNAME.getIndex()];
		String description = row[DesiredAttribute.ITEMDESCRIPTION.getIndex()];
		String type = row[DesiredAttribute.ITEMTYPE.getIndex()];
		float price = Float.parseFloat(row[DesiredAttribute.ITEMPRICE.getIndex()]);

		//Construct the MenuItem
		MenuItem m = new MenuItem(name, description, type, price);
		//Return the constructed MenuItem
		return m;
	}
	//Printing the customers, employees and menuitems database generated 
	public static void printDatabase()
	{
		System.out.println("================CUSTOMERS==============================");
		for (Person p : customersDB)
		{
			p.print();
		}
		System.out.println("=======================================================");
		System.out.println("================EMPLOYEES==============================");
		for (Person p : employeesDB)
		{
			p.print();
		}
		System.out.println("=======================================================");
		System.out.println("================MENU ITEMS==============================");
		for (MenuItem m : menuItemsDB)
		{
			m.print();
		}
		System.out.println("=======================================================");
	}
	//Combining every customer and employee into one list for checking 
	public static List<Person> getPersonList()
	{
		List<Person> everyone = new ArrayList<Person>(employeesDB);
		everyone.addAll(customersDB);
		return everyone;
	}
}
