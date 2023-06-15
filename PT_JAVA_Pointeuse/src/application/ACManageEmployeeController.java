package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Class for the Employees' modification page display!
 */
public class ACManageEmployeeController
{
	
	@FXML
	private Label labelId;
	
	String employeeId;
	
	@FXML
	private TextField textFieldFirstName;
	
	@FXML
	private TextField textFieldLastName;
	
	@FXML
	private ComboBox<String> comboBoxDepartment;
	
	
	@FXML
	private void initialize()
	{
		labelId.textProperty().addListener((observable, oldValue, newValue) -> {
		    //System.out.println("label changed from " + oldValue + " to " + newValue);
			employeeId = newValue;
			textFieldLastName.setText(employeeId);
			for (Department department : CentralApplication.Enterprise1.getListDepartment())
			{
				for (Employee employee : department.getListEmployees())
				{
					if (employee.getId().equals(employeeId)) {
						textFieldFirstName.setText(employee.getFirstName());
						textFieldLastName.setText(employee.getLastName());
						comboBoxDepartment.setValue(department.getName());
					}
					
				}
			}
		});
	}
	
	/**
	 * Define the function of a button to confirm the modification of an employee.
	 * We return to the previous page after that.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonConfirm(ActionEvent event)
	{
		
		System.out.println(employeeId);
		try
		{
			//** We load the FXML file to display the window with the shape of the staff management page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
	
	/**
	 * Define the function of a button to remove an employee (fire him from the enterprise).
	 * We return to the previous page after that.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonFire(ActionEvent event)
	{
		try
		{
			for (Department department : CentralApplication.Enterprise1.getListDepartment())
			{
				if (department.getEmployeeById(employeeId) != null)
				{
					department.DeleteEmployee(department.getEmployeeById(employeeId));
				}
			}
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
		
		try
		{
			//** We load the FXML file to display the window with the shape of the staff management page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
	
	/**
	 * Define the function of a button to go to the staff management page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBack(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the staff management page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
}
