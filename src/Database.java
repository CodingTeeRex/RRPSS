import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	static List<Person> employeesDB = new ArrayList<Person>();
	static List<Person> customersDB = new ArrayList<Person>();
	static List<MenuItem> menuItemsDB = new ArrayList<MenuItem>();

	
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
		ITEMTYPE ("ItemType", 0);

		static DesiredAttribute[] desired = DesiredAttribute.values();
		private String name;
		private int index;
		public String getName(){ return this.name; }
		public int getIndex(){ return this.index; }
		public void setIndex(int index) { this.index = index; }
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
		public static void print()
		{
			
			for (DesiredAttribute d : desired)
			{
				System.out.println(d.getName() + d.getIndex());
			}
		}
		DesiredAttribute(String name, int index)
		{
			this.name = name;
		}
	}
	public static void main(String[] args) 
	{
		parseCSV("src");
		printDatabase();
	}
	
	public static void parseCSV(String folderPath)
	{
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile() && file.getName().contains(".csv")) {
		        System.out.println(file.getName());
		        System.out.println(file.getAbsolutePath());
		        parseData(file.getAbsolutePath(), file.getName());
		    }
		}
	}
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
				reader = new BufferedReader(new FileReader(file));
				int count = 0;
				//Reading the first line to obtain attribute from csv
				if (type.contains("Person"))
				{	
					line = reader.readLine();
					String[] attributes = line.split(",");
					
					for (int i = 0; i < attributes.length; i++ )
					{
						DesiredAttribute.setIndex(attributes[i], i);
					}
					
					while ((line = reader.readLine()) != null)
					{
						String[] personRow = line.split(",");
						
						if (personRow[DesiredAttribute.ID.getIndex()].equals("NA"))
						{
							customersDB.add(InitialiseCustomer(personRow));
						}
						else
						{
							employeesDB.add(InitialiseEmployee(personRow));
						}						
					}
				}
				else
				{
					line = reader.readLine();
					String[] row = line.split(",");
					
					for (int i = 0; i < row.length; i++ )
					{
						DesiredAttribute.setIndex(row[i], i);
					}
					while ((line = reader.readLine()) != null)
					{
						String[] itemRow = line.split(",");
						
						menuItemsDB.add(InitialiseMenuItem(itemRow));
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	}
	public static Customer InitialiseCustomer(String[] row)
	{
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		String member = row[DesiredAttribute.MEMEBERTYPE.getIndex()];
		
		
		Customer c = new Customer(firstName, lastName, gender, contactNumber, member);
		return c;
	}
	public static Employee InitialiseEmployee(String[] row)
	{
		String firstName = row[DesiredAttribute.FIRSTNAME.getIndex()];
		String lastName = row[DesiredAttribute.LASTNAME.getIndex()];
		String gender = row[DesiredAttribute.GENDER.getIndex()];
		int contactNumber = Integer.valueOf(row[DesiredAttribute.CONTACT.getIndex()]);
		int id = Integer.valueOf(row[DesiredAttribute.ID.getIndex()]);
		String title = row[DesiredAttribute.TITLE.getIndex()];
		
		
		Employee e = new Employee(firstName, lastName, gender, contactNumber, id, title);
		return e;
	}
	public static MenuItem InitialiseMenuItem(String[] row)
	{
		String name = row[DesiredAttribute.ITEMNAME.getIndex()];
		String description = row[DesiredAttribute.ITEMDESCRIPTION.getIndex()];
		String type = row[DesiredAttribute.ITEMTYPE.getIndex()];
		
		
		MenuItem m = new MenuItem(name, description, type);
		return m;
	}
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
}
