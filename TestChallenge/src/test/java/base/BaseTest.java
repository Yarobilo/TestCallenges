package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties locators = new Properties();
	public static FileReader fr;
	public static FileReader fr_locators;

	public void setUp() throws IOException, InterruptedException {

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		if (driver == null) {
			System.out.println("The path is: " + System.getProperty("user.dir"));
			fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
			fr_locators = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");
			prop.load(fr);
			locators.load(fr_locators);

		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testUrl"));
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testUrl"));

		}

		driver.manage().window().maximize();


	}


	public void tearDown() {

		driver.quit();
	}

	public long[] createArrayFromNumber(String str) {

		char[] chArr = str.toCharArray();
		long[] arr = new long[chArr.length];
		for (int i = 0; i < chArr.length; i++) {
			arr[i] = Character.getNumericValue(chArr[i]);
		}
		return arr;
	}

	public String ValidCNP(String data) {

		BaseTest bt = new BaseTest();

		long[] arr = bt.createArrayFromNumber(data);

		arr[0] *= 2;
		arr[1] *= 7;
		arr[2] *= 9;
		arr[3] *= 1;
		arr[4] *= 4;
		arr[5] *= 6;
		arr[6] *= 3;
		arr[7] *= 5;
		arr[8] *= 8;
		arr[9] *= 2;
		arr[10] *= 7;
		arr[11] *= 9;

		long sum = Arrays.stream(arr).sum();
		System.out.println(sum);

		long divisor = 11;
		long remainder = sum % divisor;

		if (remainder == 10) {
			remainder = 1;
		}

		System.out.println(remainder);

		return data + "" + remainder;
	}

}
