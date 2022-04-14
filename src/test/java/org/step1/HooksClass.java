
package org.step1;

import java.io.IOException;

import org.base.BaseClass;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksClass extends BaseClass {
	
	@Before
	public void beforeScenario() {
	configBrowseAndMax("chrome");
	launchUrl("https://adactinhotelapp.com/index.php");
		
	}
	
@After
public void afterclass(Scenario s) throws IOException {
	
	takeSreenShot(s.getName());
	
	
	
	
	
}

}
