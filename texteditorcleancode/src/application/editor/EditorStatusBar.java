package application.editor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class EditorStatusBar {

	public EditorStatusBar() {
		initStatusBar();
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Elemente der StatusBar
	 * ******************************************************************************
	 ********************************************************************************/

	private Label labelLengthAndLines = new Label("Length: 0\tLines: 1");
	private Label labelCaretPos = new Label("Ln: 1\t  Col: 1");
	private Label labelDate = new Label();

	/********************************************************************************
	 * ******************************************************************************
	 * initialisierung der StatusBar
	 * ******************************************************************************
	 ********************************************************************************/

	private void initStatusBar() {
		// Datum und Uhrzeit
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy -- HH:mm:ss", Locale.GERMAN);
			labelDate.setText(LocalDateTime.now().format(formatter));
		}), new KeyFrame(Duration.seconds(1)));
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	/********************************************************************************
	 * ******************************************************************************
	 * Getter & Setter
	 * ******************************************************************************
	 ********************************************************************************/

	public Label getLabelLengthAndLines() {
		return labelLengthAndLines;
	}

	public Label getLabelCaretPos() {
		return labelCaretPos;
	}

	public Label getLabelDate() {
		return labelDate;
	}

	public void setLabelLengthAndLines(String value) {
		this.labelLengthAndLines.setText(value);
	}

	public void setLabelCaretPos(String value) {
		this.labelCaretPos.setText(value);
	}
}
