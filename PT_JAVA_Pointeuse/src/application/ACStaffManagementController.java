package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Class for the staff management page display!
 */
public class ACStaffManagementController {

	//** We create a table with all the necessary columns to display informations about the employees **//
	@FXML
	private TableView<EmployeeDept> tableViewStaffManagement;
	@FXML
	private TableColumn<EmployeeDept, String> tableColumnID;
	@FXML
	private TableColumn<EmployeeDept, String> tableColumnFirstName;
	@FXML
	private TableColumn<EmployeeDept, String> tableColumnLastName;
	@FXML
	private TableColumn<EmployeeDept, String> tableColumnDepartment;
	
	@FXML
	private ComboBox<String> mainIdBox;
	
	@FXML
	private Label ACCreateEmployeeLabelId;
	
	/**
	 * To display informations of all the employees such as their ID, names and department.
	 * To list every department inside a combobox (to chose where the employee is working in the enterprise).
	 */
	@FXML
	private void initialize()
	{
		//** We define the columns and the information they will show **//
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tableColumnDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));

		//** We create a list to make it easier to display on a tableview **//
		ObservableList<EmployeeDept> listEmployees = FXCollections.observableArrayList();

		//** And we stock all information concerning every employee in this list **//
		for (Department department : CentralApplication.Enterprise1.getListDepartment())
		{
			for (Employee employee : department.getListEmployees())
			{
				//** We had in this list a class created specifically for the display by having the ID, first name, surname of an employee and the department where he works **//
				listEmployees.add(new EmployeeDept(employee.getId(), employee.getFirstName(), employee.getLastName(), department.getName()));
			}
		}
		//** Ready to be displayed **//
		tableViewStaffManagement.setItems(listEmployees);
		
		ObservableList<String> mainString =FXCollections.observableArrayList();
		//** We search for every department in the enterprise **//
		for (Department department : CentralApplication.Enterprise1.getListDepartment())
		{
			//** Then for all the employees **//
			for (Employee employee : department.getListEmployees())
			{
				//** And we add their id to the combobox **//
				mainString.add(employee.getId());
				//** The default value of the combobox (instead of having it empty) **//
				mainIdBox.setValue(employee.getId());
			}
		}
		mainIdBox.setItems(mainString);
	}

	/**
	 * Define the function of a button to go to the employee's creation page.
	 * 
	 * @param event the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonCreateEmployee(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the employee's creation page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACCreateEmployeeView.fxml"));

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
	 * Define the function of a button to go to the employee's modification and suppression page.
	 * 
	 * @param event the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonManageEmployee(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the employee's manage page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACManageEmployeeView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
			
			ACCreateEmployeeLabelId = (Label) CentralApplication.root.lookup("#labelId");
			ACCreateEmployeeLabelId.setText(mainIdBox.getValue());
		}

		catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	/**
	 * Define the function of a button to go to the Main page.
	 * 
	 * @param event the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBackToHome(ActionEvent event)
	{
		try
		{
			// ** We load the FXML file to display the window with the shape of the Main
			// page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("CentralApplicationView.fxml"));

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
