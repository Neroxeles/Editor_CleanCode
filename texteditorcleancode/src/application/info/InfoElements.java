package application.info;

import javafx.scene.control.Label;

public class InfoElements {

	private Label labelSave = new Label(
			"Unter Datei lassen sich Texte bequem speichern.\nUnter 'Speichern unter' lässt sich der Speicherort wählen");
	private Label labelEdit = new Label(
			"Unter 'Bearbeiten' lassen sich einige kleinere Funktionen wie Komplettmarkierung,\nVor und Zurück und kleinere Anpassungen finden");
	private Label labelShortcuts = new Label(
			"Befehle wie Strg c zum Kopieren und Strg s zum Speichern\nlassen sich ebenfalls in diesem Editor verwenden");
	private Label labelFormat = new Label(
			"Unter 'Zeilenumbruch' lässt sich auswählen,\nob ein Zeilenumbruch am Ende der TextBox erwünscht ist.\nUnter 'Schriftart....' lassen sich Schriftart sowie Größe frei wählen");
	private Label labelSearchReplace = new Label(
			"Mithilfe von 'Suchen und Ersetzen' lassen sich Wörter gezielt\nsuchen und durch andere gewählte Wörter austauschen");
	private Label labelStatus = new Label(
			"Unter 'Statusleiste' finden sich Informationen über die Postion des Zeiges,\ndie Anzahl der Wörter, der verwendete Dateienpfad sowie das Datum");
	private Label labelAbout = new Label(
			"Versionsnummer: Beta 1.3\nAutoren: Robert Schoenfeld, Karl Domenic Berger, Kai Holland-Letz\nLetztes Update: 10.09.2020");

	public Label getLabelSave() {
		return labelSave;
	}

	public Label getLabelEdit() {
		return labelEdit;
	}

	public Label getLabelShortcuts() {
		return labelShortcuts;
	}

	public Label getLabelFormat() {
		return labelFormat;
	}

	public Label getLabelSearchReplace() {
		return labelSearchReplace;
	}

	public Label getLabelStatus() {
		return labelStatus;
	}

	public Label getLabelAbout() {
		return labelAbout;
	}
}
