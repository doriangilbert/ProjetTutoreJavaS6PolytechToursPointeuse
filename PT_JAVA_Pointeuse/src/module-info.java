module PT_JAVA_Pointeuse {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens fr.univtours.polytech.ptjavapointeuse.centralapp.model to javafx.graphics, javafx.fxml, javafx.base;
	opens fr.univtours.polytech.ptjavapointeuse.centralapp.controller to javafx.graphics, javafx.fxml, javafx.base;
	opens fr.univtours.polytech.ptjavapointeuse.emulatorapp.controller to javafx.graphics, javafx.fxml, javafx.base;
}
