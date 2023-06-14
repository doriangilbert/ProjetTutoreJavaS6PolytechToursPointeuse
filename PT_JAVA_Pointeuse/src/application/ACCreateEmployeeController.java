package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Class for the Check in/out history page display!
 */
public class ACCreateEmployeeController
{
	
	@FXML
	private TextField TextFirstName;
	
	@FXML
	private TextField TextLastName;
	
	@FXML
	private ComboBox<String> mainDepartmentBox;
	
	@FXML
	private void initialize() {
		mainDepartmentBox.setValue("Informatique");
		ObservableList<String> mainString =FXCollections.observableArrayList();
		for (Department dp : CentralApplication.Enterprise1.getListDepartment()) {
			mainString.add(dp.getName());
		}
		mainDepartmentBox.setItems(mainString);
	}
	
	@FXML
	protected void handleButtonConfirm(ActionEvent event)
	{
		if (TextFirstName.getText()!=null && TextFirstName.getText()!=null) {
			try {
				CentralApplication.IdCounter++;
				String Id=String.valueOf(CentralApplication.IdCounter);
				CentralApplication.Enterprise1.getDepartmentByName(mainDepartmentBox.getValue()).addEmployee(new Employee(Id,TextFirstName.getText(),TextLastName.getText()));
				System.out.println(CentralApplication.Enterprise1.getDepartmentByName(mainDepartmentBox.getValue()).getListEmployees().size());
			}
			catch (IOException e) {
				System.out.println("L'employée existe déjà");
				CentralApplication.IdCounter--;
				
			}

		}
		
		System.out.println("Confirm button pressed");
	}
	
	/**
	 * Define a button to go to the staff management page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBack(ActionEvent event)
	{
		try
		{
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
