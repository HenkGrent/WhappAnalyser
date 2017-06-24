package GUI.fxmlControllers;

import java.io.File;
import java.io.IOException;

import analysis.pojo.Group;
import analysis.pojo.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Contains elements and method referenced in the analysisScreen .fxml.
 * 
 * @author Henk
 *
 */
public class analysisScreenController {

	@FXML
	PieChart PieChartMD;
	@FXML
	TextArea consoleRight;
	@FXML
	Label filePathLabel;
	@FXML
	HBox processBar;
	@FXML
	Button menuButtonBuild;
	@FXML
	Label processLabel;
	@FXML
	VBox processHBox;
	@FXML
	AnchorPane anchorPane;
	
	/**
	 * File path selected using fileSelect().
	 */
	private String filePath;
	
	/**
	 * Group used for analysis.
	 */
	private Group group;

	/**
	 * Called when an action is performed on MenuButtonInject.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void disableButton() throws IOException {
	}

	/**
	 * Called when menuButtonInject is clicked.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void buildGroup() throws Exception {
		this.group = new Group("AnyGroup");
		group.setFilePath(getFilePath());
		group.buildUsers();
		group.buildUserMessages();
		group.calculateUserPercentages();
		group.calculateUserPercentagesChar();
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		for(final User user : group) {
			PieChart.Data input = new PieChart.Data(user.getName(), user.charactersPercentage());
			pieChartData.add(input);
		}

		PieChartMD.setData(pieChartData);
	}

	/**
	 * Called when buttonSelectFile is clicked.
	 * Opens a new screen which enables you to select a file from your file system.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void fileSelect() throws IOException {
		Stage primaryStage = (Stage) PieChartMD.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select chat");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files: ", "*.txt"));

		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		setFilePath(selectedFile.getPath());

		// Show file path, enable button and set background.
		filePathLabel.setText("Selected file: " + this.getFilePath());
		menuButtonBuild.setDisable(false);
		processLabel.setBackground(anchorPane.getBackground());
	}
	
	/// Start Getters and Setters ///
	
	/**
	 * Sets the file path of the file selected in fileSelect().
	 * @param filePath The path of the file to use (for a group).
	 */
	public void setFilePath(final String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * Gets the file path of the file selected in fileSelect();
	 * @return
	 */
	public String getFilePath() {
		return this.filePath;
	}
}