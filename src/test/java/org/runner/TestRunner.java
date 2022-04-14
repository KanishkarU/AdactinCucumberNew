package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.step1.GenerateReport;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\Feature\\AdactinLogin.feature"},snippets=SnippetType.CAMELCASE,glue= {"org.step1"},monochrome=true,

plugin= {"html:C:\\Users\\kanis\\Documents\\New folder\\AdactinCucumber\\target",
		"json:C:\\\\Users\\\\kanis\\\\Documents\\\\New folder\\\\AdactinCucumber\\\\target\\login.json",
		"junit:C:\\\\Users\\\\kanis\\\\Documents\\\\New folder\\\\AdactinCucumber\\\\target\\login.xml"

		},tags= {"@smoke"},dryRun=false
)
public class TestRunner {
	
@AfterClass
public static void reportGenaration() {
	GenerateReport.generateReport("C:\\Users\\kanis\\Documents\\New folder\\AdactinCucumber\\target\\login.json");
}
}
