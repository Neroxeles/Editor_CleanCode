package application.controller;

public class Values {

	// Dateipfad der aktuell ge�ffneten Datei
	private String filePath = "Unknown";
	// Liegen aktualisierte Datens�tze vor?
	private boolean isUpdated = false;
	// Pr�fe ob der aktuelle Prozess abgebrochen werden soll
	private boolean isCanceled = false;
	// Schriftart
	private String fontfamily = "Arial";
	// Schriftgr��e
	private int fontSize = 10;

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

	public String getFontfamily() {
		return fontfamily;
	}

	public void setFontfamily(String fontfamily) {
		this.fontfamily = fontfamily;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
