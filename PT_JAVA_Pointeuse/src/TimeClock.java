import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.util.Map;
import java.time;

public class TimeClock
{
	//***Attributs***//
	private float Version;
	private InetSocketAddress IPPort;
	private Array CheckStorage;
	private Map EmployeeCheck;
	
	
	//***Methodes***//
	TimeClock()
	{
		this.Version = 0;
		
	}
	
	public void Autocomplete()
	{
		
	}
	
	void RoundTime()
	{
		
	}
	
	int[] GetDate()
	{
		int [] date = new int[2];
		date[0] = 1;
		date[1] = Year.now();
		return date;
	}
	
	void DisplayTime()
	{
		
	}
	
	void DisplayDate()
	{
		
	}
	
	float DisplayVersion()
	{
		return this.Version;
	}
	
	void ModifierVersion(float version)
	{
		this.Version = version;
	}
	
	void DisplayEmployee()
	{
		
	}
	
	void getEmployee()
	{
		
	}
	
	void SendMapCheck()
	{
		
	}
	
	boolean VerifyConnection()
	{
		return false;
	}
}
