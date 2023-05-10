package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import de.codingsolo.seleniumkurs.configuration.Config;
import de.codingsolo.seleniumkurs.configuration.DriverHelper;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;

@RunWith(Parameterized.class)
public class TestForm1ParameterizedSeleniumKursFireFox {

	private static final Logger logger = LogManager
			.getLogger(TestForm1ParameterizedSeleniumKursFireFox.class.getName());

	WebDriver driver;

	String browsername;
	String username;
	String password;
	String betreff;
	String name;
	String kursTitel;
	int[] firmenBox1;
	int[] firmenBox2;
	String assert1;
	String assert2;

	public TestForm1ParameterizedSeleniumKursFireFox(String testName, String browsername, String username,
			String password, String betreff, String name, String kursTitel, int[] firmenBox1, int[] firmenBox2,
			String assert1, String assert2) {
		this.browsername = browsername;
		this.username = username;
		this.password = password;
		this.betreff = betreff;
		this.name = name;
		this.kursTitel = kursTitel;
		this.firmenBox1 = firmenBox1;
		this.firmenBox2 = firmenBox2;
		this.assert1 = assert1;
		this.assert2 = assert2;
	}

	@Before
	public void setUp() throws Exception {
		logger.info("Initialisiere Webdriver");
		driver = DriverHelper.getDriver(browsername);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Config.getBasURL());
	}

	@After
	public void tearDown() throws Exception {
		logger.info("Test abgeschlossen- ich räume");
		takeScreenshot(driver);
		driver.close();
	}

	@Test
	public void testForm1() {
		logger.info("Starte TestForm1 Testseite");

		// Arrange

		// Login
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben(username, password);
		loginPage.loginButtonAnklicken();
		logger.info("Login war erfolgreich");
		// Navigation zum Formular
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.testForm1anklicken();
		logger.info("Navigation zum Formular");
		// Starte Formular
		SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver);
		logger.info("Starte Eingabe Formular");
		testForm1Page.betreffEingeben(betreff);
		testForm1Page.nameEingeben(name);

		testForm1Page.kursAuswaehlen(kursTitel);

		testForm1Page.firmaInBox1Auswaehlen(firmenBox1);
		testForm1Page.firmenUerbernehmen();
		testForm1Page.firmaInBox2Auswaehlen(firmenBox2);
		testForm1Page.ausgewählteFirmenNachObenVerschieben();

		// Act
		logger.info("Eingaben durchgeführt. Speicher das Formular");
		testForm1Page.formularSpeichern();

		// Assert

		String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
		assertTrue(erfolgsMeldung.contains(assert1));

		String erstesElement = testForm1Page.erstesListenElementAuslesen();
		assertEquals(erstesElement, assert2);
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

		Object[][] daten = { { "Test Form 1 Test 1 FireFox", "firefox", "selenium102", "codingsolo",
				"Parametrisierter Test 1", "Dieter", "Java Grundlagen Kurs mit Dieter", new int[] { 2, 4, 6 },
				new int[] { 2 }, "Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" } };

		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}
	
	private void takeScreenshot(WebDriver driver) {
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Path srcPath = srcFile.toPath();
			Path targetPath = new File("screenshot_testform3.png").toPath();
			Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
