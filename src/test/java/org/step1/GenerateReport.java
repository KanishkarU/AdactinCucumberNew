package org.step1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class GenerateReport {
	
	public static void generateReport(String json) {
		
		File file = new File ("C:\\Users\\kanis\\Documents\\New folder\\AdactinCucumber\\target\\report.html");
		Configuration configuration = new Configuration(file, "adactinlogin");	
		
	configuration.addClassifications("Browser", "Chrome");
	configuration.addClassifications("Client", "Adactin");
	configuration.addClassifications("Automation tool version", "3.14.3");
	
	List< String>li = new ArrayList<>();
	li.add(json);
	ReportBuilder builder = new ReportBuilder(li, configuration);
	 builder.generateReports();
	
	
	}

}
