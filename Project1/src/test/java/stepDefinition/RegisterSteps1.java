package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import utils.ExcelRead;

public class RegisterSteps1 extends Driver {
	private Actions actions;
	private WebDriverWait wait;



	//public void TestLogin(String Username, String Password,String  Status) throws Exception {
	
	
	@Given("User on the Home page")
	public void user_on_the_home_page() {
		assertTrue(driver.getTitle().equals("Demo Web Shop"));
		logger.info("Demo Web Shop title is verified");
	}
	@When("User click on Rigster button")
	public void user_click_on_rigster_button() {
		register.clickOnResisterLink();
		
	}

//	@Test(dataProvider = "loginData", dataProviderClass = ExcelUtility.class)
	
	@When("User fill in the personal details")
	public void user_fill_in_the_personal_details() throws IOException {
		String[][] data = ExcelRead.getData("C:\\Users\\Asha\\eclipse-workspace\\Project1\\Excel Data\\Data.xlsx", "Sheet1");
		
		
		for(int i=1;i<data.length;i++) {
			String fname=data[i][0];
			String lname=data[i][1];
			String email=data[i][2];
			String pass=data[i][3];
			String cpass=data[i][4];
			
			register.clickOnRadioBtn();
			register.EnterFirstNameTextBox(fname);
			register.EnterLastNameTextBox(lname);
			register.EnterEmailTextBox(email);
			register.EnterPasswordTextBox(pass);
			register.EnterConfirmPasswordTextBox(cpass);
			
			//String result = "pass";
			//data[i][5]= System.out.println(result);
		}
		
		
		
		
	}
	@When("User click on the Register button")
	public void user_click_on_the_register_button() {
		register.clickRigesterBtn();
	}
	@When("User should see a Register message")
	public void user_should_see_a_register_message() {
			assertTrue(driver.getTitle().equals("Demo Web Shop. Register"));
			logger.warn("Tilte Should be verified");
		
		}
		
	@When("User click on Continue")
	public void user_click_on_continue() throws InterruptedException {
		register.clickContinueBtn();
	}
	@Then("User should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() {
		assertTrue(driver.getTitle().equals("Demo Web Shop"));
	}
}

