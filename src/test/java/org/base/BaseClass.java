package org.base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
///import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.SELContext;
import com.google.common.base.CaseFormat;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BaseClass {

	public static   WebDriver driver;
	public static Actions actions ;
		public static 	JavascriptExecutor executor = (JavascriptExecutor) driver;

	public static  void configBrowseAndMax(String text) {

		switch (text) {
		case "chrome":
			

			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			

			break;
		case "firfox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:
			System.out.println("invalid browser");

		}
		driver.manage().window().maximize();
		

	}

	public void setPropertyConfig(String s, String location) {
		switch (s) {
		case " chrome":

			System.setProperty("webdriver.chrome.driver", location);
			driver = new ChromeDriver();

			break;
		case " firefox":

			System.setProperty("webdriver.recko.driver", location);
			driver = new FirefoxDriver();

			break;
		case " opera":

			System.setProperty("webdriver.opera.driver", location);
			driver = new OperaDriver();

			break;
		case " InternetExplorer":

			System.setProperty("webdriver.opera.driver", location);
			driver = new OperaDriver();

			break;

		default:
			System.out.println("invalid browser");
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public String printTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String printCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void closeWindow() {
		driver.close();
	}

	public static void closeAllWindow() {
		driver.quit();
	}

	public WebElement getElemet(String s,String idornameorcalssorxapath) {
		WebElement element= null;
		
		switch (s) {
		
		case "id":
			element  = driver.findElement(By.id(idornameorcalssorxapath));
			break;
		case "name":
			 element = driver.findElement(By.name(idornameorcalssorxapath));
			break;
		case "classname":
			element = driver.findElement(By.className(idornameorcalssorxapath));
			break;
		case "xapth":
			element = driver.findElement(By.xpath(idornameorcalssorxapath));
			break;

		default:
			System.out.println("invalid Locator");
		}
		return element;
	}

	

	

	public int frameCount(String tagName) {

		List<WebElement> findElement = driver.findElements(By.tagName(tagName));
		int a = 0;
		for (int i = 0; i < findElement.size(); i++) {

			a++;
		}
		return a;

	}

	public void insertText(WebElement element, String text) {

		element.sendKeys(text);
	}

	public void btnClick(WebElement element) {
		element.click();

	}

	public void txtClear(WebElement element) {
		element.clear();

	}

	public String printText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String printAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);

	}

	public void launchUrlBynavigate(String url) {
		driver.navigate().to(url);

	}

	public void navigation(String s) {
		
		driver.navigate().refresh();

	}

	public void pageBackward() {
		driver.navigate().back();

	}

	public void pageForward() {
		driver.navigate().forward();

	}

	public void mouseHoverAction(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
		;

	}

	public void dragDrop(WebElement s, WebElement d) {
		new Actions(driver).dragAndDrop(s, d).perform();

	}

	public void rightClick(WebElement element) {
		new Actions(driver).contextClick(element).perform();

	}

	public void clickDoublk(WebElement element) {

		new Actions(driver).doubleClick(element).perform();

	}

	public void keysOn(WebElement element, Keys k) {
		new Actions(driver).keyDown(k).perform();

	}

	public void keysOff(WebElement element, Keys k) {
		new Actions(driver).keyUp(k).perform();

	}

	public void insertTextKeyonAndOff(WebElement element, String text, Keys k, Keys k1) {

		new Actions(driver).keyDown(k).sendKeys(text).keyDown(k1).perform();
	}

	public void insertTextAndkeyOnorOff(WebElement element, String text, Keys k) {

		element.sendKeys(text, k);

	}

	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;

	}

	public void clickOk(Alert alert) {
		alert.accept();

	}

	public void clickCancel(Alert alert) {
		alert.dismiss();
	}

	public void alertText(Alert alert, String text) {
		alert.sendKeys(text);
	}

	public String alertText(Alert alert) {

		return alert.getText();
	}

	public void takeSreenShot(String name ) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File temp = screenshot.getScreenshotAs(OutputType.FILE);
		File location = new File(name+".png");
		FileUtils.copyFile(temp, location);

	}

	public void specificScreenShot(WebElement element, String storeLocation) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File temp = screenshot.getScreenshotAs(OutputType.FILE);
		File location = new File(storeLocation);
		FileUtils.copyFile(temp, location);

	}

	public void executeByJs(String setvalueTrueFalse, WebElement elements ,String setOrScrollDownOrUp) {
		
		switch (setOrScrollDownOrUp) {
		case "set":
			executor.executeScript("arguments[0].setAttribute('value','"+setvalueTrueFalse+"')",elements);
			break;
		case "scroll":
			executor.executeScript("arguments[0].scrollIntoView(('"+setvalueTrueFalse+"')",elements);
	
			break;
			default:
				System.out.println("action not done or locator not found");
		}
		
	}

	public Object jsGetAttribute(String s, WebElement... elements) {
		return executor.executeAsyncScript(s, elements);

	}

	public void jsLaunchBrowser(String s) {
		executor.executeAsyncScript(s);

	}

	public int getOptionsCount(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		int a =0;
		for (int i = 0; i < options.size();i++) {
			
			a++;
		}
return a;

	}

	public void selectByVisibleText(WebElement element, String s) {
		Select select = new Select(element);
	
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();

			if (text.equals(s)) {
				select.selectByVisibleText(text);
			}

		}

	}

	public void selectByValue(WebElement element, String s) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String attribute = webElement.getAttribute("value");
			if (attribute.equals(s)) {
				select.selectByValue(attribute);
			}

		}

	}

	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {
			if (i == index) {
				s.selectByIndex(i);
			}
		}
	}

	public void selectAllByValue(WebElement element) {
		Select s = new Select(element);

		List<WebElement> options = s.getOptions();
		for (int j = 0; j < options.size(); j++) {
			WebElement webElement = options.get(j);
			String attribute = webElement.getAttribute("value");
			s.selectByValue(attribute);
		}

	}

	public void selectAllByVisibleText(WebElement element) {
		Select s = new Select(element);
		if (s.isMultiple()) {
			List<WebElement> options = s.getOptions();
			for (int j = 0; j < options.size(); j++) {
				WebElement webElement = options.get(j);
				String text = webElement.getText();
				s.selectByValue(text);
			}
		}
	}

	public void selectAllIndex(WebElement element) {
		Select s = new Select(element);
		if (s.isMultiple()) {
			List<WebElement> options = s.getOptions();
			for (int j = 0; j < options.size(); j++) {

				s.selectByIndex(j);
			}
		}
	}

	public void deSelectByVisibleText(WebElement element, String s) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();

			if (text.equals(s)) {
				select.deselectByVisibleText(text);
			}

		}

	}

	public void deselectByValue(WebElement element, String s) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String attribute = webElement.getAttribute("value");
			if (attribute.equals(s)) {
				select.deselectByValue(attribute);
			}

		}

	}

	public void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {
			if (i == index) {
				s.selectByIndex(i);
			}
		}
	}

	public void deselectAllByValue(WebElement element) {
		Select s = new Select(element);
		if (s.isMultiple()) {
			List<WebElement> options = s.getOptions();
			for (int j = 0; j < options.size(); j++) {
				WebElement webElement = options.get(j);
				String attribute = webElement.getAttribute("value");
				s.selectByValue(attribute);
			}
		}
	}

	public void deselectAllByVisibleText(WebElement element) {
		Select s = new Select(element);
		if (s.isMultiple()) {
			List<WebElement> options = s.getOptions();
			for (int j = 0; j < options.size(); j++) {
				WebElement webElement = options.get(j);
				String text = webElement.getText();
				s.selectByValue(text);
			}
		}
	}

	public void deselectAllIndex(WebElement element) {
		Select s = new Select(element);
		if (s.isMultiple()) {
			List<WebElement> options = s.getOptions();
			for (int j = 0; j < options.size(); j++) {

				s.selectByIndex(j);
			}
		}
	}

	public void getAllSelectedValue(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement webElement = allSelectedOptions.get(i);

			System.out.println(webElement.getText());

		}

	}

	public String getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption.getText();

	}

	public boolean isMutiple(WebElement element) {
		Select s = new Select(element);
		return s.isMultiple();

	}

	public void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();

	}

	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	public void swithToFrameByIdOrName(String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

	public void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	public void switchToWindowByTitle() {
		String title = driver.getTitle();
		driver.switchTo().window(title);

	}

	public void switchtoWindowByUrl() {
		String currentUrl = driver.getCurrentUrl();
		driver.switchTo().window(currentUrl);

	}

	public void getParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(windowHandle.equals(string))) {

				driver.switchTo().window(string);

			}

		}

	}
	//public String getValueFromExcel(String sheetName, int rowNo,int c) throws IOException {
//		File file = new File("C:\\Users\\kanis\\Documents\\New folder\\MavenTasks\\Excel\\TestData.xlsx");
//		FileInputStream inputStream = new FileInputStream(file);
//		Workbook wb = new XSSFWorkbook(inputStream);
//		Sheet sheet = wb.getSheet(sheetName);
//		Row row = sheet.getRow(rowNo);
//		Cell cell = row.getCell(c);
//		CellType cellType = cell.getCellType();
//		String value = null;
//		switch (cellType) {
//		case STRING:
//			value = cell.getStringCellValue();
//			
//			break;
//			
//		case NUMERIC:
//		if(DateUtil.isCellDateFormatted(cell)) {
//			Date dateCellValue = cell.getDateCellValue();
//			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
//			 String format = s.format(dateCellValue);
//			 value=format;
//		}
//		else {
//			double numericCellValue = cell.getNumericCellValue();
//			BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
//			String string = valueOf.toString();
//			value = string;
//			
//			
//		}
//
//		default:
//			break;
//		}
//		return value;
//		
//	}
//public void insertCellInExcel(String sheetName,int rowNo,int colNo,String text) throws InvalidFormatException, IOException {
//	File file = new File("C:\\Users\\kanis\\Documents\\New folder\\MavenTasks\\Excel\\TestData.xlsx");
//	FileInputStream inputStream = new FileInputStream(file);
//	Workbook wb = new XSSFWorkbook(inputStream);
//	Sheet sheet = wb.getSheet(sheetName);
//	Row row = sheet.getRow(rowNo);
//	Cell createCell = row.createCell(colNo);
//	createCell.setCellValue(text);
//	FileOutputStream outputStream = new FileOutputStream (file);
//	wb.write(outputStream);
	
}

