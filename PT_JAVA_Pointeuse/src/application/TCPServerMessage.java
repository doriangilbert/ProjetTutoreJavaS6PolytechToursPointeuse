package application;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TCPServerMessage extends TCPServerBuilder implements Runnable {

	public void run() {
		do {
			String message = this.receive();
			System.out.println("CentralApplication : Message Received : " + message);
			String[] parsedMessage = message.split(",");
			long timeStamp = Long.parseLong(parsedMessage[0]);
			System.out.println("timeStamp : " + timeStamp);
			LocalDateTime parsedTimeStamp = LocalDateTime.ofEpochSecond(timeStamp, 0,
					ZoneId.systemDefault().getRules().getOffset(Instant.now()));
			System.out.println("Check Time : ");
			System.out.println(parsedTimeStamp);
			System.out.println(parsedTimeStamp.getDayOfWeek() + " " + parsedTimeStamp.getDayOfMonth() + " "
					+ parsedTimeStamp.getMonth() + " " + parsedTimeStamp.getYear() + " " + parsedTimeStamp.getHour()
					+ ":" + parsedTimeStamp.getMinute());
			String employeeId = parsedMessage[1];
			System.out.println("Check employeeId : " + employeeId);
			Employee EmployeeParam = null;
			String NameDepartment=null;
			for( Department Dp : CentralApplication.Enterprise1.getListDepartment()) {
				for (Employee Em : Dp.getListEmployees()) {
					if (Em.getId().equals(employeeId)) {
						EmployeeParam=Em;
						NameDepartment=Dp.getName();
					}
				}
			}
			if (EmployeeParam!=null) {
				Boolean IsACheckIn=true;
				for (Check Ck: EmployeeParam.getListCheck()) {
					if (Ck.getDate().toLocalDate().equals(parsedTimeStamp.toLocalDate())){
						IsACheckIn=false;
					}
				}
				try {
					System.out.println(CentralApplication.Enterprise1.getDepartmentByName(NameDepartment).getEmployeeById(employeeId).getListCheck().size());
					EmployeeParam.addCheck(new Check(IsACheckIn,false,parsedTimeStamp));
					System.out.println(CentralApplication.Enterprise1.getDepartmentByName(NameDepartment).getEmployeeById(employeeId).getListCheck().size());
				}
				catch (IOException e) {
					
				}
			}
			else {
				System.out.println("Id doesn't correspond to an existing employee");
			}
		} while (true);
	}

	public String receive() {
		String msIn = "";
		try {
			setSocket();
			s = ss.accept();
			InputStream in = s.getInputStream();
			setStreamBuffer(ss.getReceiveBufferSize());
			msIn = readMessage(in);
			System.out.println("TCPServer : Message Received : " + msIn);
			s.close();
			ss.close();
		} catch (IOException e) {
			System.out.println("IOException TCPServerMessage");
		}
		return msIn;
	}
}
