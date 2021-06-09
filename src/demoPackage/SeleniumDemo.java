package demoPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumDemo {

	public WebDriver driver;
	public String baseUrl = "https://google.com";
	String driverPath = "C:\\Users\\manoj\\Desktop\\Selenium Workspace\\Selenium_demo\\src\\MSE Driver\\msedgedriver.exe";

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void testBrokenLinks() {
//
//		String homePage = "https://www.guru99.com";
//		String url = "";
//		HttpURLConnection huc = null;
//		int respCode = 200;
//
//		driver.manage().window().maximize();
//
//		driver.get(homePage);
//
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		int totalLinks = links.size();
//		String homePage1 = "https://www.guru99.com/";
//		String homePage2 = "https://www.guru99.com/#";
//		int validLinks = 0, brokenLinks = 0, anotherDomain = 0,homepageLinks=0;
//
//		Iterator<WebElement> it = links.iterator();
//
//		while (it.hasNext()) {
//
//			url = it.next().getAttribute("href");
//
////			System.out.println(url);
//
//			if (url == null || url.isEmpty()) {
//				System.out.println("URL is either not configured for anchor tag or it is empty");
//				continue;
//			}
//
//			if (!url.startsWith("https://www.guru99.com")) {
//				System.out.println("URL belongs to another domain, skipping it. " + url);
//				anotherDomain++;
//				continue;
//			}
//
//			if (url.equalsIgnoreCase(homePage1) || url.equalsIgnoreCase(homePage2)) {
//				System.out.println("Home Page, Skipping " + url);
//				homepageLinks++;
//				continue;
//			}
//
//			try {
//				huc = (HttpURLConnection) (new URL(url).openConnection());
//
//				huc.setRequestMethod("HEAD");
//
//				huc.connect();
//
//				respCode = huc.getResponseCode();
//
//				if (respCode >= 400) {
//					System.out.println("broken link " + url);
//					brokenLinks++;
//				} else {
//					System.out.println("valid link " + url);
//					validLinks++;
//				}
//
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		System.out.println("Total hyperLinks found : " + totalLinks);
//		System.out.println("Total valid links = " + validLinks);
//		System.out.println("Total broken links = " + brokenLinks);
//		System.out.println("Total links from another domain = " + anotherDomain);
//		System.out.println("Total homepage links = "+homepageLinks);
//
//	}

//	@Test
//	public void testTable() throws InterruptedException, ParseException {
//
//		driver.get("http://demo.guru99.com/test/web-table-element.php");
//		String max;
//		double m = 0, r = 0;
//
//		// No. of Columns
//		List col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
//		System.out.println("Total No of columns are : " + col.size());
//		// No.of rows
//		List rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
//		System.out.println("Total No of rows are : " + rows.size());
//		for (int i = 1; i < rows.size(); i++) {
//			max = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+(i+1)+"]/td[4]"))
//					.getText();
//			NumberFormat f = NumberFormat.getNumberInstance();
//			Number num = f.parse(max);
//			max = num.toString();
//			m = Double.parseDouble(max);
//			if (m > r) {
//				r = m;
//			}
//		}
//		System.out.println("Maximum current price is : " + r);
//
//	}
	
	
	@Test
	public void testTitle() throws InterruptedException {

		driver.get(baseUrl);

		driver.findElement(By.name("q")).sendKeys("Prime minister of India");
		driver.findElement(By.name("btnK")).click();

		String expectedTitle = "Prime minister of India - Google Search";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);

	}
//
//	@Test
//	public void testPM() {
//		
//		driver.get(baseUrl);
//		driver.findElement(By.name("q")).sendKeys("Prime minister of India");
//		driver.findElement(By.name("btnK")).click();
//		
//		String actualPM = driver.findElement(By.className("FLP8od")).getText();
//		String expectedPM = "Narendra Modi";
//		
//		System.out.println("Prime minister of India is "+actualPM);
//		
//		Assert.assertEquals(actualPM, expectedPM);
//	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}

}
