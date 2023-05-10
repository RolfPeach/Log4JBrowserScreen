package de.codingsolo.seleniumkurs.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum AvailableBrowser {

	FIREFOX {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();

			return driver;
		}
	},
	CHROME {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;
		}
	},
	IE {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();

			return driver;
		}
	};

	public abstract WebDriver createDriver();
}
