package application;

import static java.lang.Thread.sleep;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class with every calculation about serialization for the CentralApplication!
 */
public class CentralApplicationSerialization implements Runnable
{

	public static Enterprise Enterprise1=new Enterprise();
	
	/**
	 * Allow the serialization of data, to put every information of an enterprise inside a file.
	 * We do that serialization every 5 seconds in case there are modifications (and if the application suddenly close)
	 */
    @Override
    public void run()
    {
    	while(true)
    	{
    		try
    		{
        		FileOutputStream fos = new FileOutputStream("Enterprise1.dat");
               	ObjectOutputStream oos = new ObjectOutputStream(fos);
               	oos.writeObject(CentralApplication.Enterprise1);
               	System.out.println("Save Finished");
               	oos.close();
               	fos.close();
               	sleep(5000);
    		}
    		
    		catch (IOException | InterruptedException error)
    		{
    			
    		}
    	}
    }
    
    /**
	 * Write all information of an enterprise (on the application) in a file
	 * 
	 * @param 	NomFichier	The directory of the file to put all the information into.
	 * @throws 	IOException
	 * @throws 	InterruptedException
	 */
	public static void Serialization(String NomFichier) throws IOException, InterruptedException
	{
		while (true)
		{
			//** To write a text inside a file **//
			FileOutputStream fos = new FileOutputStream(NomFichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Enterprise1);
			oos.close();
			//** We do that every 5 seconds (to save any possible modifications) **//
			sleep(5000);
		}
	}

	/**
	 * Take out all information of an enterprise from a file
	 * 
	 * @param	NomFichier	The directory of the file to take all the information from.
	 * @return				The information of a certain enterprise stocked in the file.
	 * @throws	IOException	
	 */
	public static Enterprise Deserialization(String NomFichier) throws IOException
	{
		//** To read the text in a file **//
		FileInputStream fis = new FileInputStream(NomFichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Enterprise enterpriseParam = new Enterprise();
		try
		{
			enterpriseParam = (Enterprise) ois.readObject();
			int IDmax=0;
			for (Department dp : enterpriseParam.getListDepartment())
			{
				for (Employee Emp : dp.getListEmployees())
				{
					if (IDmax<Integer.parseInt(Emp.getId()))
					{
						IDmax=Integer.parseInt(Emp.getId());
					}
				}
			}
			IDmax++;
			Employee.IdCounter=IDmax;
		}
		
		catch (ClassNotFoundException error)
		{

		}
		ois.close();
		return enterpriseParam;
	}
}