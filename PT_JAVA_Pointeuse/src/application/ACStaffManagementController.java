package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Class for the staff management page display!
 */
public class ACStaffManagementController
{

	@FXML
	private TableView<Employee> tableViewStaffManagement;
	@FXML
	private TableColumn<Employee, String> tableColumnID;
	@FXML
	private TableColumn<Employee, String> tableColumnFirstName;
	@FXML
	private TableColumn<Employee, String> tableColumnLastName;
	
	@FXML
	private void initialize()
	{
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		//TODO : Récupérer la liste des employés et gérer les départements
		Employee employee1 = new Employee("1", "John", "Doe");
		Employee employee2 = new Employee("2", "Jane", "Smith");
		Employee employee3 = new Employee("3", "Bob", "Johnson");
		
		tableViewStaffManagement.setItems(FXCollections.observableArrayList(employee1, employee2, employee3));

	}
	
	
	/**
	 * Define the function of a button to go to the employee's creation page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
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
	 * Define the function of a button to go to the Main page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBackToHome(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the Main page **//
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
