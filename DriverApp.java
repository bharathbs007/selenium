package testApps;


import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import testReports.TestReports;
import util.TestConfig;
import util.TestUtil;
import datatable.Xlfile_Reader;
import util.DbManager;


public class DriverApp{
	
	public static Properties CONFIG;
	public static Properties Objects;
	public static Properties APPTEXT;
	public static Xlfile_Reader Core;
	public static Xlfile_Reader testData=null;
	public static Xlfile_Reader DBresults=null;
	public static Random randomGenerator = new Random(); // Random Port Number generation 
	public static String currentTest;
	public static String keyword;
    public static WebDriver dr=null;
	public static EventFiringWebDriver driver=null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	public static String data_column_name;
	public static int  testRepeat;
	public static int nSelPort;
	public static String sSelPort;
	public static Calendar cal = new GregorianCalendar();
	public static  int month = cal.get(Calendar.MONTH);
	public static int year = cal.get(Calendar.YEAR);
	public static  int sec =cal.get(Calendar.SECOND);
	public static  int min =cal.get(Calendar.MINUTE);
	public static  int date = cal.get(Calendar.DATE);
	public static  int day =cal.get(Calendar.HOUR_OF_DAY);
	public static String strDate;
	public static String result;


	//Get the current system time - used for generated unique file ids (ex: Screenshots, Reports etc on every test run)
	public static String getCurrentTimeStamp()
    { 
          SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy"+"_"+"HH-mm-ss");
          Date now = new Date(); 
         String CDate = CurrentDate.format(now); 
          return CDate; 
    }

	//Loaded the Selenium and Application log files
	
	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger.getLogger("deployingLogger");
		
	String Url ="https://itc-hotels.net.in/content/itc_final.html";
	
	
   	@BeforeSuite
	public void startTesting() throws Exception{
   		
   		// Code to Generate random numbers
   		
		 nSelPort = randomGenerator.nextInt(40000);
		 strDate=getCurrentTimeStamp();
     	System.out.println("date time stamp :"+strDate);
		 
		 // Start testing method will start generating the Test Reports from the beginning       
		TestReports.startTesting("C://Automation//apache-tomcat-7.0.27//webapps//ROOT//htmlpages//index"+strDate+".html",
		TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), 
        "ITC Automation Project",
        "1.0");
		
		
       //Loading Config File
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
		CONFIG.load(fs);
		
		
		// LOAD Objects properties File
		Objects = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"//src//config//Objects.properties");
		Objects.load(fs);
		
	
		//Load datatable
		Core= new Xlfile_Reader(System.getProperty("user.dir")+"//src//config//Core.xlsx");
		testData  =  new Xlfile_Reader(System.getProperty("user.dir")+"//src//config//TestData.xlsx");

		System.setProperty("webdriver.chrome.driver"
				,"E://selenium//chromedriver.exe");
	//	HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		//  HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
				dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);	
				driver.get(Url);
				//closeicon();
				//wait for 30 seconds and then fail
				driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);	
				driver.manage().window().maximize();
		 		
	}
   	
	private static void closeicon() {
		// Find an element and define it
		WebElement elementToClick = driver.findElement(By.xpath("//div/span[@class='guide-close']"));
		// Scroll the browser to the element's Y position
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
		// Click the element
		elementToClick.click();
		
	} 
	
	@Test
	
	public void testApp() {
		
		String startTime=null;
		
		TestReports.startSuite("Suite 1");
		
		for(int tcid=2 ; tcid<=Core.getRowCount("Suite1");tcid++){
			currentTest = Core.getCellData("Suite1", "TCID", tcid);
			
			// initilize start time of test
			if(Core.getCellData("Suite1", "Runmode", tcid).equals("Y")){
				
				// executed the keywords
				
				// loop again - rows in test data
				int totalSets=testData.getRowCount(currentTest+"1"); // holds total rows in test data sheet. IF sheet does not exist then 2 by default
				if(totalSets<=1){
					totalSets=2; // run atleast once
				}
					
				for( testRepeat=2; testRepeat<=totalSets;testRepeat++){	
					startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");

				APPLICATION_LOGS.debug("Executing the test "+ currentTest);
				
				// implemented keywords file
				try{
				for(int tsid=2;tsid<=Core.getRowCount(currentTest);tsid++){
					
					
					// Get values from xls file
					
					keyword=Core.getCellData(currentTest, "Keyword", tsid);
					object=Core.getCellData(currentTest, "Object", tsid);
					currentTSID=Core.getCellData(currentTest, "TSID", tsid);
					stepDescription=Core.getCellData(currentTest, "Description", tsid);
					proceedOnFail=Core.getCellData(currentTest, "ProceedOnFail", tsid);
					data_column_name=Core.getCellData(currentTest, "Data_Column_Name", tsid);
					Method method= Keywords.class.getMethod(keyword);
					result = (String)method.invoke(method);
					APPLICATION_LOGS.debug("***Result of execution -- "+result);
					
					// take screenshot - every keyword
					String fileName="Suite1_TC"+(tcid-1)+"_TS"+tsid+"_"+keyword+testRepeat+".jpg";
				
					
					if(result.startsWith("Pass")){
						testStatus=result;
						
						//Uncomment this one to capture screenshots in case of Pass, For every test step a screenshot will be captured
						//TestUtil.captureScreenshot(CONFIG.getProperty("screenshotPath")+TestUtil.imageName+".jpeg");
						
					TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+":8080//screenshots//"+TestUtil.imageNameIP+".jpeg");
					
					}
					
					else if(result.startsWith("Fail")){
							testStatus=result;
							// take screenshot - only on error
						TestUtil.captureScreenshot(CONFIG.getProperty("screenshotPath")+TestUtil.imageName+".jpeg");
					    	
							//changed to make the screenshot path generic
						TestReports.addKeyword(stepDescription, keyword, result, "http://"+TestUtil.Handeler()+":8080//screenshots//"+TestUtil.imageNameIP+".jpeg");
							
							if(proceedOnFail.equalsIgnoreCase("N")){
								
								break;
																
							}
						break;
						
						}
					
					}
					
					
				}
				catch(Throwable t){
					APPLICATION_LOGS.debug("Error came");
					
				}
				
				// report pass or fail in HTML Report
				
				if(testStatus == null){
					testStatus="Pass";
				}
				APPLICATION_LOGS.debug("######################"+currentTest+" --- " +testStatus);
				TestReports.addTestCase(currentTest, 
										startTime, 
										TestUtil.now("dd/MMMMM/yyyy hh:mm:ss aaa"),
										testStatus );
				
				if(result.startsWith("Fail")){
				
					break; 
	                  }
				
				}
			}else{
				APPLICATION_LOGS.debug("Skipping the test "+ currentTest);
				testStatus="Skip";
				
				// report skipped
				APPLICATION_LOGS.debug("#######################"+currentTest+" --- " +testStatus);
				TestReports.addTestCase(currentTest, 
										TestUtil.now("dd/MMMMM/yyyy hh:mm:ss aaa"), 
										TestUtil.now("dd/MMMMM/yyyy hh:mm:ss aaa"),
										testStatus );
				
			}
			
			testStatus=null;
			
			if(result != null && result.startsWith("Fail")){
                break; 
                }

		}
		TestReports.endSuite();
	}
	
	@AfterSuite
	public static void endScript() throws Exception{
		
		// Once the test is completed update the end time in HTML report
		TestReports.updateEndTime(TestUtil.now("dd/MMMMM/yyyy hh:mm:ss aaa"));
		driver.quit();
		
	}
}

	
	
