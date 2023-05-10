package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm1Page {

	WebDriver driver;

	@FindBy(tagName = "h1")
	private WebElement testFormHeadline;

	@FindBy(id = "form-widgets-betreff")
	private WebElement inputBetreff;

	@FindBy(id = "form-widgets-name")
	private WebElement inputName;

	@FindBy(id = "form-widgets-auswahl1")
	private WebElement selectKurs;

	@FindBy(id = "form-widgets-auswahl2-from")
	private WebElement selectFirmaBox1;

	@FindBy(name = "from2toButton")
	private WebElement btnAuswahlFirmaBox1;

	@FindBy(id = "form-widgets-auswahl2-to")
	private WebElement selectFirmaBox2;

	@FindBy(name = "upButton")
	private WebElement btnAuswahlObenBox2;

	@FindBy(name = "form.buttons.speichern")
	private WebElement btnSpeicherDokument;

	@FindBy(id = "message")
	private WebElement StatusMeldung;

	@FindBy(xpath = "//ul[@id='companies']/li[1]")
	private WebElement textErstesElementListeFirma;

	public SeleniumKursTestForm1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String ueberschriftAuslesen() {
		return testFormHeadline.getText();
	}

	public void betreffEingeben(String betreff) {
		inputBetreff.sendKeys(betreff);
	}

	public void nameEingeben(String name) {
		inputName.sendKeys(name);
	}

	public void kursAuswaehlen(String kursName) {
		Select selectKurs = new Select(this.selectKurs);
		selectKurs.selectByVisibleText(kursName);
	}

	public void firmaInBox1Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox1);
		for (int i : auswahl) {
			selectFirma.selectByIndex(i);
		}
	}

	public void firmenUerbernehmen() {
		btnAuswahlFirmaBox1.click();
	}

	public void firmaInBox2Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox2);
		for (int i : auswahl) {
			selectFirma.selectByIndex(i);
		}
	}

	public void ausgewählteFirmenNachObenVerschieben() {
		btnAuswahlObenBox2.click();
	}

	public void formularSpeichern() {
		btnSpeicherDokument.click();
	}

	public String statusMeldungAuslesen() {
		return StatusMeldung.getText();
	}

	public String erstesListenElementAuslesen() {
		return textErstesElementListeFirma.getText();
	}

}
