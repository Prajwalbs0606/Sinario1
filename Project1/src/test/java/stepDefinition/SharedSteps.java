package stepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pagefactory.LandingPageAfterLogin;
import pagefactory.Register;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;



public class SharedSteps extends Tools{

	@Before
	public void setUp(Scenario scenario) {
		Driver.init();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}

class Tools {
	protected static WebDriver driver;
}

class Driver extends Tools{
	public static RequestSpecification httprequest;
	public static Response response;
	
	public static Logger logger;
	protected static LandingPageAfterLogin landingpageafterlogin;
	protected static Register register;
	public static void init() {
		driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demowebshop.tricentis.com/");
 landingpageafterlogin = new LandingPageAfterLogin(driver);
	    register =new Register(driver);
	    logger = Logger.getLogger("LogDemo");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
}
}
