package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursWebElementePage {

	WebDriver driver;

	@FindBy(id = "checkBoxOption1")
	private WebElement checkBox1;
	@FindBy(id = "checkBoxOption2")
	private WebElement checkBox2;
	@FindBy(id = "checkBoxOption3")
	private WebElement checkBox3;

	@FindBy(css = "input[value='radio1']")
	private WebElement radioBtn1;
	@FindBy(css = "input[value='radio2']")
	private WebElement radioBtn2;
	@FindBy(css = "input[value='radio3']")
	private WebElement radioBtn3;

	public SeleniumKursWebElementePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void checkBox1Anklicken() {
		checkBox1.click();
	}

	public void checkBox2Anklicken() {
		checkBox2.click();
	}

	public void checkBox3Anklicken() {
		checkBox3.click();
	}

	public boolean checkBox1StatusAuslesen() {
		return checkBox1.isSelected();
	}

	public boolean checkBox2StatusAuslesen() {
		return checkBox2.isSelected();
	}

	public boolean checkBox3StatusAuslesen() {
		return checkBox3.isSelected();
	}

	public void radioButton1Anklicken() {
		radioBtn1.click();
	}

	public void radioButton2Anklicken() {
		radioBtn2.click();
	}

	public void radioButton3Anklicken() {
		radioBtn3.click();
	}

	public String radioButton1getAttribute(String attributename) {
		return radioBtn1.getAttribute(attributename);
	}

	public String radioButton2getAttribute(String attributename) {
		return radioBtn2.getAttribute(attributename);
	}

	public String radioButton3getAttribute(String attributename) {
		return radioBtn3.getAttribute(attributename);
	}

}
