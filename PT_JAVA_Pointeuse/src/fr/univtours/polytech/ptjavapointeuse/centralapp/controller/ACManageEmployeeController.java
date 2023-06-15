package fr.univtours.polytech.ptjavapointeuse.centralapp.controller;

import java.io.IOException;

import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Department;
import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Employee;
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
	
	/**
	 * Take care of displaying all elements on the window.
	 */
	@FXML
	private void initialize()
	{
		//** We take the ID of the employee we want to modify or fire **//
		labelId.textProperty().addListener((observable, oldValue, newValue) ->
		{
			employeeId = newValue;
			textFieldLastName.setText(employeeId);
			for (Department department : CentralApplication.Enterprise1.getListDepartment())
			{
				for (Employee employee : department.getListEmployees())
				{
					//** We pre-fill the data of the employee we want to modify (to not rewrite everything) **//
					if (employee.getId().equals(employeeId))
					{
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
	 * We only change the first name and surname of the employee.
	 * With our methods, changing the department means firing the employee to hire him in an other department.
	 * (so his ID will change and we don't want that)
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonConfirm(ActionEvent event)
	{
		//** If we have filled all the text boxes **//
		if (!textFieldFirstName.getText().isBlank() && !textFieldLastName.getText().isBlank())
		{
			try
			{
				for (Department department : CentralApplication.Enterprise1.getListDepartment())
				{
					if (department.getEmployeeById(employeeId) != null)
					{
						//** We try to modify information about the employee **//
						department.getEmployeeById(employeeId).setFirstName(textFieldFirstName.getText());
						department.getEmployeeById(employeeId).setLastName(textFieldLastName.getText());
					}
				}
			}
				
			catch (IOException error)
			{
				//** If the employee already exists, we do nothing **//
				System.out.println("The employee already exists");	
			}
		}
		
		try
		{
			//** We load the FXML file to display the window with the shape of the staff management page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("/fr/univtours/polytech/ptjavapointeuse/centralapp/view/ACStaffManagementView.fxml"));

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
			CentralApplication.root = FXMLLoader.load(getClass().getResource("/fr/univtours/polytech/ptjavapointeuse/centralapp/view/ACStaffManagementView.fxml"));

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
			CentralApplication.root = FXMLLoader.load(getClass().getResource("/fr/univtours/polytech/ptjavapointeuse/centralapp/view/ACStaffManagementView.fxml"));

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
