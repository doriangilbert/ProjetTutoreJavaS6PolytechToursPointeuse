package fr.univtours.polytech.ptjavapointeuse.centralapp.controller;

import java.io.IOException;

import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Department;
import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Employee;
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
		ObservableList<String> mainString =FXCollections.observableArrayList();
		//** We search for every department in the enterprise **/
		for (Department department : CentralApplication.Enterprise1.getListDepartment())
		{
			//** And we add them to the combobox **//
			mainString.add(department.getName());
			//** The default value (instead of an empty combobox) **//
			mainDepartmentBox.setValue(department.getName());
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
		if (!TextFirstName.getText().isBlank() && !TextFirstName.getText().isBlank())
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
	
	/**
	 * Define the function of a button to go to the department creation page.
	 * 
	 * @param 	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonCreateDepartment(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the create department page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("/fr/univtours/polytech/ptjavapointeuse/centralapp/view/ACCreateDepartmentView.fxml"));

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
