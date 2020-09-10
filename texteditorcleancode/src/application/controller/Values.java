package application.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Values {

	public Values() {
		try {
			loadProperties();
		} catch (Exception e) {
			try {
				saveProperties();
			} catch (Exception e1) {
			}
		}
	}

	// Dateipfad der aktuell geöffneten Datei
	private String filePath = "Unknown";
	// Liegen aktualisierte Datensätze vor?
	private boolean isUpdated = false;
	// Prüfe ob der aktuelle Prozess abgebrochen werden soll
	private boolean isCanceled = false;
	// Schriftart
	private String fontFamily = "Arial";
	// Schriftgröße
	private int fontSize = 10;

	private Properties property = new Properties();

	/*
	 * Save Property
	 */
	public void saveProperties() throws Exception {
		OutputStream out = new FileOutputStream("configuration.properties");

		property.setProperty("FontFamily", fontFamily);
		property.setProperty("FontSize", Integer.toString(fontSize));

		property.store(out, null);
	}

	/*
	 * Load Properties
	 */
	private void loadProperties() throws Exception {
		InputStream in = new FileInputStream("configuration.properties");
		property.load(in);

		fontFamily = property.getProperty("FontFamily");
		fontSize = Integer.parseInt(property.getProperty("FontSize"));
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontfamily) {
		this.fontFamily = fontfamily;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
