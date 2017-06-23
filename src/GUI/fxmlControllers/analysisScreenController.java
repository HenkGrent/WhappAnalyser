package GUI.fxmlControllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
	Button MenuButtonInject;
	@FXML
	Label processLabel;
	@FXML
	VBox processHBox;
	@FXML
	AnchorPane anchorPane;

	/**
	 * Called when an action is performed on MenuButtonInject.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void disableButton() throws IOException {
	}

	/**
	 * Called when MenuButtonInject is clicked.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void addPieChartData() throws Exception {
		// Implement this.
	}

	/**
	 * Called when buttonSelectFile is clicked.
	 * 
	 * @throws IOException
	 *             The element may not exist.
	 */
	public void fileSelect() throws IOException {
	}
}