package application;

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
 * Class for the Check in/out history page display!
 */
public class ACCheckInOutHistoryController
{

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
	
	
	@FXML
	private void initialize()
	{
		tableColumnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("time"));
		tableColumnEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tableColumnType.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		ObservableList<EmployeeCheck> listChecks = FXCollections.observableArrayList();

		for (Department department : CentralApplication.Enterprise1.getListDepartment())
		{
			for (Employee employee : department.getListEmployees())
			{
				for (Check check : employee.getListCheck()) {
					String checkType;
					if (check.getisACheckIn()) {
						checkType = "in";
					}
					else {
						checkType = "out";
					}
					listChecks.add(new EmployeeCheck(check.getDate().toLocalDate(), check.getDate().toLocalTime(), employee.getId(), employee.getFirstName(), employee.getLastName(), checkType));
				}
			}
		}
		tableViewCheckInOutHistory.setItems(listChecks);
	}
	
	/**
	 * Define the function of a button to go to the today's check history page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonTodayChecks(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the today's check history page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACTodayCheckInOutHistoryView.fxml"));

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
