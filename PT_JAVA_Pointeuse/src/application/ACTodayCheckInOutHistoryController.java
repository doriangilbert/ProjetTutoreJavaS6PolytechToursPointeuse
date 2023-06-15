package application;

import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Class for the today's check in/out history page display!
 */
public class ACTodayCheckInOutHistoryController
{
	
	//** We create a table with all the necessary columns to display informations about the checks **//
	@FXML
	private TableView<EmployeeCheck> tableViewCheckInOutHistory;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnDate;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnHour;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnEmployeeId;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnFirstName;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnLastName;
	@FXML
	private TableColumn<EmployeeCheck, String> tableColumnType;
	
	/**
	 * To display informations of all the checks such as their time code, the employee who did the check and its type (in/out).
	 * We take only today's check into account with this function.
	 */
	@FXML
	private void initialize()
	{
		//** We define the columns and the information they will show **//
		tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("time"));
		tableColumnEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		//** We create a list to make it easier to display on a tableview **//
		ObservableList<EmployeeCheck> listChecks = FXCollections.observableArrayList();

		//** And we stock all information concerning today's every check in this list **//
		for (Department department : CentralApplication.Enterprise1.getListDepartment())
		{
			for (Employee employee : department.getListEmployees())
			{
				for (Check check : employee.getListCheck()) 
				{
					String checkType;
					//** If there isn't a check today **//
					if (check.getisACheckIn()) 
					{
						checkType = "in";
					}
					//** If the employee already checked in today **//
					else 
					{
						checkType = "out";
					}
					//** If this is one of today's check, we had it **//
					if (check.getDate().toLocalDate().equals(LocalDateTime.now().toLocalDate())) 
					{
						//** We add in this list a class created specifically for the display by having the things cited above **//
						listChecks.add(new EmployeeCheck(check.getDate().toLocalDate(), check.getDate().toLocalTime(), employee.getId(), employee.getFirstName(), employee.getLastName(), checkType));
					}
				}
			}
		}
		//** Ready to be displayed **//
		tableViewCheckInOutHistory.setItems(listChecks);
	}
	
	/**
	 * Define the function of a button to go to the check in/out history page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBack(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the check in/out history page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACCheckInOutHistoryView.fxml"));

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
