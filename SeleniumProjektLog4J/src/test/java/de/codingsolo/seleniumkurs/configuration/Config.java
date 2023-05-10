package de.codingsolo.seleniumkurs.configuration;

import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static String configfile = "myconfig.properties";
	private static Properties properties = loadProperties();
	
	public static String getBasURL() {
		String baseURL = (String) properties.get("baseurl");
		throwExceptionWhenNull("baserurl", baseURL);
		return baseURL;
	}
	
	public static String getBrowserName(String browsername) {
		String browser = (String) properties.get(browsername);
		throwExceptionWhenNull(browsername, browser);
		return browser;
	}
	
	public static String getBrowserDriver(String browserdriver) {
		String browserDriver = (String) properties.get(browserdriver);
		throwExceptionWhenNull(browserdriver, browserDriver);
		return browserDriver;
	}
	
	private static void throwExceptionWhenNull(String property, String Parameter) {
		if (Parameter == null) {
			throw new RuntimeException("Parameter: "+property+" nicht in der Konfigurationsdatei gefunden.");
		}
	}

	private static Properties loadProperties() {

		try {

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Properties props = new Properties();

			InputStream is = loader.getSystemResourceAsStream(configfile);
			props.load(is);

			return props;

		} catch (Exception e) {
			throw new RuntimeException("Keine Konfigurationsdatei gefunden", e);
		}
	}

}
