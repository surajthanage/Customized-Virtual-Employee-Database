import java.lang.*;
import java.util.*;


//Database table
class Employee
{
	public String name;
	public String Address;
	public String  Designation;
	public int Salary;
	public int RID;
	
	private static int Generator;
	
	static 
	{
		Generator=0;
	}
	
	public Employee(String str,int value,String str2,String str1)
	{
		this.RID=++Generator;
		this.name=str;
		this.Salary=value;
		this.Address=str1;
		this.Designation=str2;
		
	}
	
	public void DisplayData()
	{
		System.out.println(this.RID+"\t"+this.name+"\t"+this.Designation+"\t"+this.Salary+"\t"+this.Address+"\t");
		
	}
}

class DBMS
{
	public LinkedList <Employee> lobj;
	
	public DBMS()
	{
		 lobj=new LinkedList<>();
	}
	
	public void StartDBSM()
	{
		Scanner scanobj=new Scanner(System.in);
		
		System.out.println(" customised DBMS strated Succesfully.......");
		System.out.println("##########################################################");
		System.out.println("#              CREATE A TABLE FOR EMPLOYE                #");
		System.out.print("# 		In this table we can stover 		 #\n# 		Name of Employee            		 #\n# 		RollNumber                   		 #\n# 		Address of employe          		 #\n# 		Salary                     		 #\n");
		System.out.println("##########################################################");
		String Query="";
	
		
		while(true)
		{
			System.out.print("Customised DBMS console >");
			String str=scanobj.nextLine();
			Query=str.toLowerCase();
			String tokens[]=Query.split(" ");
			int QuerySize=tokens.length;
			
			if(QuerySize==1)	
			{
				if("help".equals(tokens[0]))
				{
					System.out.println("This application is used to demonstrate the customised DBMS ");
					System.out.println("---------------------------------------------------------------");
					//help exit
					System.out.println("help Exit");
					System.out.println("Help Insert");
					System.out.println("Help update ");
					System.out.println("Help Display ");
					System.out.println("Help Delete ");
					System.out.println("Help Minimum ");
					System.out.println("Help Maximum");
					System.out.println("Help Avrage ");
					System.out.println("Help Count ");
					System.out.println("Help Summation ");
					System.out.println("---------------------------------------------------------------");
				}
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thank you for using Customised DBMS");
					break;
				}
			}
			else if(QuerySize==2)
			{
				if("help".equals(tokens[0]))
				{
					
					if("insert".equals(tokens[1])) 
					{
						System.out.println("-----------------------------------------------------------------");
						System.out.println("Syntax : Insert into employee name salary designation address ");
						System.out.println("Usage  : Insert value in table ");
						System.out.println("---------------------------------------------------------------------");
					}
					else if("exit".equals(tokens[1]))
					{
						System.out.println("-----------------------");
						System.out.println("Syntax : Exit ");
						System.out.println("Usage  : write exit ");
						System.out.println("------------------------");
					}
					else if("display".equals(tokens[1]))
					{
						System.out.println("---------------------------------------");
						System.out.println("Syntax :select * from employee ");
						System.out.println("Usage  :Display all data ");
						System.out.println("Syntax :select RID =  ? from employee  ");
						System.out.println("Usage  :Display data using RID");
						System.out.println("Syntax :select name =  ? from employee ");
						System.out.println("Usage  :Display data using name");
						System.out.println("Syntax :select Designation =  ? from employee e");
						System.out.println("Usage  :Display data using Designation");
						System.out.println("----------------------------------------");
					
					}
					else if("delete".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax :delete from employee where rid  =  ? ");
						System.out.println("Usage  :Remove data using RID");
						System.out.println("Syntax :delete from employee where name = ?");
						System.out.println("Usage  :Remove data using name");
						System.out.println("Syntax :delete from employee where address = ?");
						System.out.println("Usage  :Remove data using adress");
						System.out.println("----------------------------------------");
					}
					else if("minimum".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax :select min (salary) from employee ");
						System.out.println("Usage  :Find the minimum");
						System.out.println("----------------------------------------");
					}
					else if("maximum".equals(tokens[1]))
					{
						System.out.println("--------------------------");
						System.out.println("Syntax :select max (salary) from employee ");
						System.out.println("Usage  :Find the maximum");
						System.out.println("--------------------------");
					}
					else if("avrage".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax :select avg (salary) from employee");
						System.out.println("Usage  :Find the avrage");
						System.out.println("----------------------------------------");
				
					}
					else if("summation".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax :select sum (salary) from employee ");
						System.out.println("Usage  :Find the summation");
						System.out.println("----------------------------------------");
				
					}
					else if("count".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax :select count( coulme_name) from Employee ");
						System.out.println("Usage  :Find the count");
						System.out.println("----------------------------------------");
				
					}
					else if("update".equals(tokens[1]))
					{
						System.out.println("----------------------------------------");
						System.out.println("Syntax : Update employee set name = ? where rid  =  ? ");
						System.out.println("Usage  : update the name ");
						System.out.println("Syntax : Update employee set salary = ? where rid  =  ? ");
						System.out.println("Usage  : update the salary ");
						System.out.println("Syntax : Update employee set Designation = ? where rid  =  ?");
						System.out.println("Usage  : update the Designation ");
						System.out.println("Syntax : Update employee set name = ? where rid  =  ?");
						System.out.println("Usage  : update the name ");
						System.out.println("----------------------------------------");
				
					}
				}
			}
			else if(QuerySize==4)
			{
				//select * from employee
				if(("select".equals(tokens[0])) && ("*".equals(tokens[1])) && ("from".equals(tokens[2])) && ("employee".equals(tokens[3])))
				{
					DisplayAll();
				}
			}
			else if(QuerySize==6)
			{
				//select RID =  ? from employee 
				if(("select".equals(tokens[0])) && ("rid".equals(tokens[1])) && ("=".equals(tokens[2])) && ("from".equals(tokens[4])) && ("employee".equals(tokens[5])))
				{
					int iNo=Integer.parseInt(tokens[3]);
					DisplaySpacific(iNo);
				}
				//select name =  ? from employee 
				else if(("select".equals(tokens[0])) && ("name".equals(tokens[1])) && ("=".equals(tokens[2])) && ("from".equals(tokens[4])) && ("employee".equals(tokens[5])))
				{
					String str1=tokens[3];
					DisplaySpacific(str1);
				}//select Designation =  ? from employee 
				else if(("select".equals(tokens[0])) && ("designation".equals(tokens[1])) && ("=".equals(tokens[2])) && ("from".equals(tokens[4])) && ("employee".equals(tokens[5])))
				{
					String str1=tokens[3];
					DisplaySpacific(str1);
				}
				else 
				{
					if(!(("select".equals(tokens[0])) && ("rid".equals(tokens[1])) && ("=".equals(tokens[2])) && ("from".equals(tokens[4])) && ("employee".equals(tokens[5]))))
					{
						System.out.println("ERROR :select RID =  ? from employee ");
					}
					else if(!(("select".equals(tokens[0])) && ("name".equals(tokens[1])) && ("=".equals(tokens[2])) && ("from".equals(tokens[4])) && ("employee".equals(tokens[5]))))
					{
						System.out.println("ERROR :select Name =  ? from employee ");
					}
				}
			}
			else if(QuerySize==5)
			{
				
				//select min (salary) from employee
				if(("select".equals(tokens[0])) && ("min".equals(tokens[1])) && ("(salary)".equals(tokens[2])) && ("from".equals(tokens[3])) && ("employee".equals(tokens[4])))
				{
					AggregateMin();
				}//select max(salary) from employee
				else if(("select".equals(tokens[0])) && ("max".equals(tokens[1])) && ("(salary)".equals(tokens[2])) && ("from".equals(tokens[3])) && ("employee".equals(tokens[4])))
				{
					AggregateMax();
				}//select sum(salary) from employee
				else if(("select".equals(tokens[0])) && ("sum".equals(tokens[1])) && ("(salary)".equals(tokens[2])) && ("from".equals(tokens[3])) && ("employee".equals(tokens[4])))
				{
					AggregateSum();
				}//select count(salary) from employee
				else if(("select".equals(tokens[0])) && ("count".equals(tokens[1])) && ("(salary)".equals(tokens[2])) && ("from".equals(tokens[3])) && ("employee".equals(tokens[4])))
				{
					AggregateCount();
				}//select avg(salary) from employee
				else if(("select".equals(tokens[0])) && ("avg".equals(tokens[1])) && ("(salary)".equals(tokens[2])) && ("from".equals(tokens[3])) && ("employee".equals(tokens[4])))
				{
					AggregateAvg();
				}
				
			}
			else if(QuerySize==7)
			{
				//delete from employee where rid  =  ?	
				if(("delete".equals(tokens[0])) && ("from".equals(tokens[1])) && ("employee".equals(tokens[2])) && ("where".equals(tokens[3])) && ("rid".equals(tokens[4])) && ("=".equals(tokens[5])))
				{
					int iNo=Integer.parseInt(tokens[6]);
					DeleteSpacific(iNo);
				}//delete from employee where name = ?
				else if(("delete".equals(tokens[0])) && ("from".equals(tokens[1])) && ("employee".equals(tokens[2])) && ("where".equals(tokens[3])) && ("name".equals(tokens[4])) && ("=".equals(tokens[5])))
				{
					String str1=tokens[6];
					DeleteSpacific(str1);
				}//delete from employee where address = ?
				else if(("delete".equals(tokens[0])) && ("from".equals(tokens[1])) && ("employee".equals(tokens[2])) && ("where".equals(tokens[3])) && ("address".equals(tokens[4])) && ("=".equals(tokens[5])))
				{
					String str1=tokens[6];
					DeleteSpacific(str1);
				}
				//Insert into employee Manish 1000 sofware_Development karjat
				else if(("insert".equals(tokens[0])) && ("into".equals(tokens[1])) && ("employee".equals(tokens[2])))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]),tokens[5],tokens[6]);
				}
				else if(!(("insert".equals(tokens[0])) && ("into".equals(tokens[1])) && ("employee".equals(tokens[2]))))
				{
					System.out.println("ERROR: Insert into employee Name Salary degignation Address..");
				}
			}
			else if(QuerySize==8)
			{
				//select * from employee where address = ?
				if(("select".equals(tokens[0])) && ("*".equals(tokens[1])) && ("from".equals(tokens[2])) && ("employee".equals(tokens[3])) && ("where".equals(tokens[4])) && ("address".equals(tokens[5])) && ("=".equals(tokens[6])))
				{
	 				DisplaySpacific(tokens[7]);

				}
				else if(!(("select".equals(tokens[0])) && ("*".equals(tokens[1])) && ("from".equals(tokens[2])) && ("employee".equals(tokens[3])) && ("where".equals(tokens[4])) && ("address".equals(tokens[5])) && ("=".equals(tokens[6]))))
				{
					System.out.println("ERROR :select * from employee where address = ");
				}
			}
			else if(QuerySize==10)
			{
				//update employee set name = ? where rid  =  ?
				if(("update".equals(tokens[0])) && ("employee".equals(tokens[1])) && ("set".equals(tokens[2])) && ("name".equals(tokens[3])) &&  ("=".equals(tokens[4])) && ("where".equals(tokens[6])) &&  ("rid".equals(tokens[7])) &&  ("=".equals(tokens[9])))
				{
					int iNo1=Integer.parseInt(tokens[10]);
					String str1 = tokens[5];
					UpdateName(iNo1,str1);
				}//update employee set salary = ? where rid = ?
				else if(("update".equals(tokens[0])) && ("employee".equals(tokens[1])) && ("set".equals(tokens[2])) && ("salary".equals(tokens[3])) &&  ("=".equals(tokens[4])) && ("where".equals(tokens[6])) &&  ("rid".equals(tokens[7])) &&  ("=".equals(tokens[9])))
				{
					int iNo1=Integer.parseInt(tokens[10]);
					int iNo2 =Integer.parseInt(tokens[5]);
					UpdateSalary(iNo1,iNo2);
				}//update employee set Address = ? where rid = ?
				else if(("update".equals(tokens[0])) && ("employee".equals(tokens[1])) && ("set".equals(tokens[2])) && ("Address".equals(tokens[3])) &&  ("=".equals(tokens[4])) && ("where".equals(tokens[6])) &&  ("rid".equals(tokens[7])) &&  ("=".equals(tokens[9])))
				{
					int iNo1=Integer.parseInt(tokens[10]);
					String str1 = tokens[5];
					UpdateAddress(iNo1,str1);
				}//update employee set Designation = ? where rid = ?
				else if(("update".equals(tokens[0])) && ("employee".equals(tokens[1])) && ("set".equals(tokens[2])) && ("designation".equals(tokens[3])) &&  ("=".equals(tokens[4])) && ("where".equals(tokens[6])) &&  ("rid".equals(tokens[7])) &&  ("=".equals(tokens[9])))
				{
					int iNo1=Integer.parseInt(tokens[10]);
					String str1 = tokens[5];
					UpdateDesignation(iNo1,str1);
				}
				
			}
			
		}
		
		
	}
	//inser tha data
	public void InsertData(String str,int value,String str1,String Add)
	{
		Employee sobj=new Employee(str,value,str1,Add);
		lobj.add(sobj);
	}
	
	//Display all data
	public void DisplayAll()
	{
		System.out.println("-------------------------------------");
		for(Employee sref:lobj)
		{
			sref.DisplayData();
		}
		System.out.println("-------------------------------------");
	}
	
	//Display spacific data using roll number
	public void DisplaySpacific(int rid)
	{
		for(Employee sref:lobj)
		{
			if(sref.RID == rid)
			{
				sref.DisplayData();
				break;
			}
		}
	}
	
	//Display spacific data using name
	public void DisplaySpacific(String str)
	{
		System.out.println("-----------------------------------");
		for(Employee sref:lobj)
		{
			
			if(str.equals(sref.name))
			{
				sref.DisplayData();
			}
			else if(str.equals(sref.Address))
			{
				sref.DisplayData();
			}
			else if(str.equals(sref.Designation))
			{
				sref.DisplayData();
			}
			
		}
		System.out.println("------------------------------------");
	}

	//display spacific Dignation and adrress
	public void DisplaySpacific(String str,String str1)
	{
		System.out.println("-----------------------------------");
		for(Employee sref:lobj)
		{
			if((str.equals(sref.Designation))&&(str1.equals(sref.Address)))
			{
				sref.DisplayData();
			}
			
		}
		System.out.println("------------------------------------");
	}
		
	//Delete data by RID
	public void DeleteSpacific(int rid)
	{
		int index=0;
		for(Employee sref:lobj)
		{
			if(sref.RID == rid)
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	//Delete data  by using name
	public void DeleteSpacific(String str)
	{
		int index=0;
		for(Employee sref:lobj)
		{
			if(str.equals(sref.name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}
	}
	
	//update name
	public void UpdateName(int id,String str)
	{
		int index=0;
		for(Employee sref :lobj)
		{
			if(sref.RID== id)
			{
				sref.name=str;
				lobj.set(index, sref);
			}
			index++;
		}
	}

	//update Designation
	public void UpdateDesignation(int id,String str)
	{
		int index=0;
		for(Employee sref:lobj)
		{
			if(sref.RID== id)
			{
				sref.Designation=str;
				lobj.set(index, sref);
			}
			index++;
		}
	}

	//update Salary
	public void UpdateSalary(int id,int iNo)
	{
		int index=0;
		for(Employee sref: lobj)
		{
			if(sref.RID== id)
			{
				sref.Salary=iNo;
				lobj.set(index, sref);
			}
			index++;
		}
	}

	//update Address
	public void UpdateAddress(int id,String str)
	{
		int index=0;
		for(Employee sref: lobj)
		{
			if(sref.RID== id)
			{
				sref.Address=str;
				lobj.set(index, sref);
			}
			index++;
		}
	}
	
	//find maximum
	public void AggregateMax()
	{
		int iMax=0;
		Employee temp=null;
		
		for(Employee sref:lobj)
		{
			if(sref.Salary > iMax)
			{
				iMax=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Information of Employee having maximum salary: ");
		temp.DisplayData();
	}
	
	//find minimum
	public void AggregateMin()
	{
		int iMin=(lobj.getFirst()).Salary;
		Employee temp=lobj.getFirst();
		
		for(Employee sref:lobj)
		{
			if(sref.Salary < iMin)
			{
				iMin=sref.Salary;
				temp=sref;
			}
		}
		System.out.println("Information of Employee having minimum salary: ");
		temp.DisplayData();
	}
	
	//find summation
	public void AggregateSum()
	{
		long iSum=0;
	
		for(Employee sref:lobj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("Summmation of Salary : "+iSum);
		
	}
	
	//find avrage
	public void AggregateAvg()
	{
		long iSum=0;
		
		for(Employee sref:lobj)
		{
			iSum=iSum+sref.Salary;
		}
		System.out.println("Avrage of Salary : "+iSum/(lobj.size()));
	}
		
	//find count	
	public void AggregateCount()
	{
		System.out.println("Count is : "+lobj.size());
	}
}

class project
{
	public static void main(String arg[])
	{
		DBMS dobj=new DBMS();
		dobj.StartDBSM();
		
		
	}
}
