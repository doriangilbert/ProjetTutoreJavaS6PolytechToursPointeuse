package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Class for the Employee's creation page display!
 */
public class ACCreateEmployeeController
{
	
	@FXML
	private TextField TextFirstName;
	
	@FXML
	private TextField TextLastName;
	
	@FXML
	private ComboBox<String> mainDepartmentBox;
	
	/**
	 * To list every department inside a combobox (to chose where the employee is working in the enterprise).
	 */
	@FXML
	private void initialize()
	{
		//** The default value **//
		mainDepartmentBox.setValue("Informatique");
		ObservableList<String> mainString =FXCollections.observableArrayList();
		//** We search for every department in the enterprise **/
		for (Department dp : CentralApplication.Enterprise1.getListDepartment())
		{
			//** And we add them to the combobox **//
			mainString.add(dp.getName());
		}
		mainDepartmentBox.setItems(mainString);
	}
	
	/**
	 * Define the function of a button to add a new employee in the enterprise.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonConfirm(ActionEvent event)
	{
		//** If we have filled all the text boxes **//
		if (TextFirstName.getText()!=null && TextFirstName.getText()!=null)
		{
			try
			{
				//** We try to add the new employee **//
				CentralApplication.Enterprise1.getDepartmentByName(mainDepartmentBox.getValue()).addEmployee(new Employee(TextFirstName.getText(),TextLastName.getText()));
				System.out.println(CentralApplication.Enterprise1.getDepartmentByName(mainDepartmentBox.getValue()).getListEmployees().size());
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
