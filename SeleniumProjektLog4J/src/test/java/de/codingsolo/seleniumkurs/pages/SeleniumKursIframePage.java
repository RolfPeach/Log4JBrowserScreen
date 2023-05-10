package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursIframePage {

	WebDriver driver;

	@FindBy(id = "name")
	private WebElement inputName;

	@FindBy(id = "alertbtn")
	private WebElement btnAlert;

	public SeleniumKursIframePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void wechselZuIframe() {
		driver.switchTo().frame("iframe");
	}

	public void namenEingeben(String name) {
		inputName.sendKeys(name);
	}

	public void alarmKnopfAnklicken() {
		btnAlert.click();
	}

	public String alarmNachrichtAuslesen() {
		return driver.switchTo().alert().getText();
	}

	public void alarmNachrichtSchliessen() {
		driver.switchTo().alert().accept();
	}

}
