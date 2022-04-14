package org.step1;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pagerepository.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {
	
public 	LoginPage page;
	
@Given("user launches GC browser and enters adactin login page")
public void userLaunchesGCBrowserAndEntersAdactinLoginPage() {
//	configBrowseAndMax("chrome");
//	launchUrl("https://adactinhotelapp.com/index.php");
    
}
	@When("user enter the user name {string}  and password {string}")
	public void user_enter_the_user_name_and_password(String string, String string2) {

page= new LoginPage();
insertText(page.getUsername(), string);
insertText(page.getPassword(), string2);
		
	}

	@When("user clicks in login button")
	public void userClicksInLoginButton() {
		page= new LoginPage();
		btnClick(page.getLoginButton());

	}

	@Then("Validating user enters into search hotel page")
	public void validatingUserEntersIntoSearchHotelPage() {
		
		String printTitle = printTitle();
		Assert.assertTrue(printTitle.contains("Search Hotel"));
System.out.println(printTitle);
	}

	@Then("user print title of the search page")
	public String userPrintTitleOfTheSearchPage() {
	return	printCurrentUrl();
		
	}

}
