package pagefactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

	private Actions actions;
	private WebDriverWait wait;

	@FindBy(xpath="//a[contains(@class,'ico-register')]")
	private WebElement ResisterLink;
	

	@FindBy(id="gender-male")
	private WebElement RadioBtn;

	@FindBy(xpath="(//input[contains(@class,'text-box single-line')])[1]")
	private WebElement FirstNameTextBox;


	@FindBy(xpath="(//input[contains(@class,'text-box single-line')])[2]")
	private WebElement LastNameTextBox;
	

	@FindBy(xpath="(//input[contains(@class,'text-box single-line')])[3]")
	private WebElement EmailTextBox;
	
	@FindBy(xpath="(//input[contains(@class,'text-box single-line password')])[1]")
	private WebElement PasswordTextBox;
	
	@FindBy(xpath="(//input[contains(@class,'text-box single-line password')])[2]")
	private WebElement ConfirmPasswordTextBox;
	
	@FindBy(id=("register-button"))
	private WebElement RegisterBtn;
	
	@FindBy(xpath="(//input[contains(@class,'button-1 register-continue-button')])")
	private WebElement ContinueBtn;
	
	JavascriptExecutor js;

	public Register(WebDriver driver)

	{
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	}

	public void addtoCart() throws InterruptedException {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView()",ResisterLink);
		js.executeScript("arguments[0].click()",ResisterLink );
		
		js.executeScript("arguments[0].scrollIntoView()",RadioBtn);
		js.executeScript("arguments[0].click()", RadioBtn);



	}
	public void clickOnResisterLink() {
		 ResisterLink.click();
	}
	
	public void clickOnRadioBtn() {
		 RadioBtn.click();
	}

	public void EnterFirstNameTextBox(String FirstName) {
		//emailtextbox.clear();
		FirstNameTextBox.sendKeys(FirstName);
	}
	
	public void EnterLastNameTextBox(String LastName) {
		//emailtextbox.clear();
		LastNameTextBox.sendKeys(LastName);
		
}
	public void EnterEmailTextBox(String Email) {
		//emailtextbox.clear();
		EmailTextBox.sendKeys(Email);
		
}
	public void EnterPasswordTextBox(String Password) {
		//emailtextbox.clear();
		PasswordTextBox.sendKeys(Password);
		
}
	public void EnterConfirmPasswordTextBox(String ConfirmPassword) {
		//emailtextbox.clear();
		ConfirmPasswordTextBox.sendKeys(ConfirmPassword);
	}
	public void clickRigesterBtn() {
		 RegisterBtn.click();
	}
	public void clickContinueBtn() throws InterruptedException {
		Thread.sleep(5000);
		 ContinueBtn.click();
	}
}
