package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursKatzenSuchenPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "p.lead")
	private WebElement textParagraph;

	@FindBy(id = "-ssxkBCAy")
	private WebElement imgKatze1;

	@FindBy(id = "29RH1pQb5")
	private WebElement imgKatze2;
	
	@FindBy(id = "IRb9aOk6K")
	private WebElement imgKatze3;
	
	@FindBy(id = "h6")
	private WebElement imgKatze4;

	@FindBy(linkText = "Next")
	private WebElement linkNext;

	@FindBy(linkText = "Previous")
	private WebElement linkPrevious;

	@FindBy(id = "anzahlSelect")
	private WebElement selectAnzahl;
	
	@FindBy(id = "sortSelect")
	private WebElement selectSortierung;
	
	public SeleniumKursKatzenSuchenPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

	public String beschreibungAuslesen() {
		return textParagraph.getText();
	}

	public String srcLinkImgKatze1Auslesen() {
		return imgKatze1.getAttribute("src");
	}

	public String srcLinkImgKatze2Auslesen() {
		return imgKatze2.getAttribute("src");
	}
	
	public String srcLinkImgKatze3Auslesen() {
		return imgKatze3.getAttribute("src");
	}
	
	public String srcLinkImgKatze4Auslesen() {
		wait.until(ExpectedConditions.elementToBeClickable(imgKatze4));
		return imgKatze4.getAttribute("src");
	}

	public void nextPage() {
		linkNext.click();
	}

	public void previousPage() {
		linkPrevious.click();
	}

	public void anzahlBilderEingeben(String anzahlWert) {
		Select anzahl = new Select(selectAnzahl);
		anzahl.selectByVisibleText(anzahlWert);
	}
	
	public void sortierungEingeben(String sortierWert) {
		Select sortierung = new Select(selectSortierung);
		sortierung.selectByValue(sortierWert);
	}	

}
