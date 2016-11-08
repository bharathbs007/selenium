package testApps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
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
import org.openqa.selenium.remote.server.handler.ExecuteAsyncScript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;








import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

public class Example {

	HSSFWorkbook workbook;
	HSSFCellStyle style ;
 	HSSFFont font ;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	static WebDriver driver;
	Map<String, Object[]> testresultdata;
	String testsiteurl;
	
	@BeforeTest
	 public void setup() {
		System.setProperty("webdriver.chrome.driver"
				,"E:/selenium/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		
	} 
	
	// We need to use IE driver (64 bit) if the system has 64 bit IE , since by default the Selenium webdriver launches 32 bit browser 
	
/*	public void setup() {
		System.setProperty("webdriver.ie.driver"
				,"E:/selenium/IEDriverServer_Win32_2.45.0/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
	}  */
	
/*	public void setup() {
		driver=new FirefoxDriver();
		
	} */
	
	
	
	public static String getExcelCellValue(String sheetName, int row, int cell)
			throws Exception {
		String xlPath = "E:\\samplee\\Book2.xlsx";
		FileInputStream fis = new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell)
				.getStringCellValue();
		return value;
	}
	
	public static void closeicon() {
		
		
		// Find an element and define it
		WebElement elementToClick = driver.findElement(By.xpath("//div/span[@class='glyphicon glyphicon-remove-circle guide-close']"));
		// Scroll the browser to the element's Y position
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+elementToClick.getLocation().y+")");
		// Click the element
		elementToClick.click();

	} 
	
	public static void selectDate(String dateofbirth)
	
	{
		List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]/option[8]"));
		//Selecting the month
		List<WebElement> element=	driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[2]/option[19]"));
		// Selecting the Days			
		List<WebElement> days = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a"));
			    		
	}
			
	
	public void getscreenshot() throws IOException  
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("E:\\screenshot.png"));
    }
	
	
	public class testNGPriority {
		@Test(priority=1)
		void executee() {
		}
		@Test(priority=2)
		void contactus () {
			
		}
	}
	
	public String readData(String key,String fileName) {
		String value ="";
		try {
			Properties properties = new Properties();
			File file = new File ("Object.properties");
			if(file.exists()) {
				properties.load(new FileInputStream(file));
				value = properties.getProperty(key);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return value;
	}
	
	
	
	@Test(description = "Signup form")
	public void executee()  {
		try{
		driver.manage().window().maximize();
		driver.get(testsiteurl);
		Thread.sleep(15000);
		String mobilenumber = getExcelCellValue("Sheet1", 1, 0);
		String emailid=getExcelCellValue("Sheet1", 1, 1);
		String firstname=getExcelCellValue("Sheet1", 1, 2);
		String lastname=getExcelCellValue("Sheet1", 1, 3);
		String pinone=getExcelCellValue("Sheet1", 1, 4);
		String pintwo=getExcelCellValue("Sheet1", 1, 5);
		String pinthree=getExcelCellValue("Sheet1", 1, 6);
		String pinfour=getExcelCellValue("Sheet1", 1, 7);
		String pinfive=getExcelCellValue("Sheet1", 1, 8);
		String pinsix=getExcelCellValue("Sheet1", 1, 9);
		String pinseven=getExcelCellValue("Sheet1", 1, 10);
		String pineight=getExcelCellValue("Sheet1", 1, 11);
		String confirmemailid=getExcelCellValue("Sheet1", 1, 12);
		String addresslineone =getExcelCellValue("Sheet1", 1, 13);
		String addresslinetwo=getExcelCellValue("Sheet1", 1, 14);
		String addresslinethree=getExcelCellValue("Sheet1", 1, 15);
		String pincod=getExcelCellValue("Sheet1", 1, 16);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("takeTourImage")));
		driver.findElement(By.id("takeTourImage")).click();
	/*	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[@class='glyphicon glyphicon-remove-circle guide-close']")));
		driver.findElement(By.xpath("//div/span[@class='glyphicon glyphicon-remove-circle guide-close']")).click();*/
	closeicon();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='signin']")));
		driver.findElement(By.xpath("//div[@class='signin']")).click();
	//	Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mobileNumber")));
		driver.findElement(By.id("mobileNumber")).sendKeys(mobilenumber);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("emailId")));
		driver.findElement(By.id("emailId")).sendKeys(emailid);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enrollCheckSubmit")));
		driver.findElement(By.id("enrollCheckSubmit")).click();
	//	Thread.sleep(5000);
		driver.findElement(By.id("mr")).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName")));
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromDate")));
		driver.findElement(By.id("fromDate")).click();
		
		// function for calling the date picker
				
		String date = "03-Sep 1997";
		String splitter[] = date.split("-");
		String dob=splitter[0];
		selectDate(dob);
		
		// Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,100)");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinOne")));
		driver.findElement(By.id("pinOne")).sendKeys(pinone);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinTwo")));
		driver.findElement(By.id("pinTwo")).sendKeys(pintwo);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinThree")));
		driver.findElement(By.id("pinThree")).sendKeys(pinthree);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinFour")));
		driver.findElement(By.id("pinFour")).sendKeys(pinfour);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinFive")));
		driver.findElement(By.id("pinFive")).sendKeys(pinfive);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinSix")));
		driver.findElement(By.id("pinSix")).sendKeys(pinsix);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinSeven")));
		driver.findElement(By.id("pinSeven")).sendKeys(pinseven);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinEight")));
		driver.findElement(By.id("pinEight")).sendKeys(pineight);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmEmailId")));
		driver.findElement(By.id("confirmEmailId")).sendKeys(confirmemailid);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addressLineone")));
		driver.findElement(By.id("addressLineone")).sendKeys(addresslineone);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addressLinetwo")));
		driver.findElement(By.id("addressLinetwo")).sendKeys(addresslinetwo);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addressLineThree")));
		driver.findElement(By.id("addressLineThree")).sendKeys(addresslinethree);
		driver.findElement(By.id("addressLineThree")).sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("state")));
		//String field_value=driver.findElement(By.id("state")).getAttribute("name");
		Select oselection2 = new Select(driver.findElement(By.id("state")));
		oselection2.selectByVisibleText("KARNATAKA");
	//	Assert.assertEquals(field_value.contains("KARNATAKA"), true);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city")));
		Select oselection1 = new Select(driver.findElement(By.id("city")));
		oselection1.selectByVisibleText("BANGALORE");
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pincode")));
		driver.findElement(By.id("pincode")).sendKeys(pincod);
		Thread.sleep(35000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='enroll-box']")));
		driver.findElement(By.xpath("//input[@class='enroll-box']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='enrollmentForm']/div[19]/div/input")));
		driver.findElement(By.xpath("//*[@id='enrollmentForm']/div[19]/div/input")).click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cancelBtn")));
		driver.findElement(By.id("cancelBtn")).click();
		
		     // assertEquals(driver.findElement(By.cssSelector("ul.cr > li > a")).getText(),"Test Selenium");
		      //add pass entry to the excel sheet
			System.out.println("Testing.....");
			 font.setColor(HSSFColor.GREEN.index);
	         style.setFont(font);
		      testresultdata.put("2", new Object[] {1d, "navigate to site and login","", "site opens and login success","site opens and login successful","Pass",""});
		    }
		    catch(IOException e)
		{
		    	handleErrorCondition(e);
		}catch(InterruptedException e)
		{
			handleErrorCondition(e);
		}
		    catch(Exception e)
		    {
		    	handleErrorCondition(e);
		    }
		
		
		
		  }
		
	
	@BeforeTest
	public void setupBeforeSuite(ITestContext context) {
	     	     //create a new work book

	      workbook = new HSSFWorkbook();
	      //create a new work sheet
	       sheet = workbook.createSheet("Test Result");
	       style = workbook.createCellStyle();
	    	 font = workbook.createFont();
	      testresultdata = new LinkedHashMap<String, Object[]>();
	      //add test result excel file column header
	      //write the header in the first row
	      testresultdata.put("1", new Object[] {"Test Step Id", "Action","Pre-Conditions", "Expected Result","Actual Result","Status","Remarks"});
	
	     	    
	  }
	
	
	@AfterTest
			public void setupAfterSuite() {
		    //write excel file and file name is TestResult.xls 
		    Set<String> keyset = testresultdata.keySet();
		    int rownum = 0;
		    for (String key : keyset) {
		        Row row = sheet.createRow(rownum++);
		        Object [] objArr = testresultdata.get(key);
		        int cellnum = 0;
		        for (Object obj : objArr) {
		            Cell cell = row.createCell(cellnum++);
		            if(obj instanceof Date) 
		                cell.setCellValue((Date)obj);
		            else if(obj instanceof Boolean)
		                cell.setCellValue((Boolean)obj);
		            else if(obj instanceof String)
		            {
		            	cell.setCellValue((String)obj);
		            	if(obj != null && (((String)obj).equalsIgnoreCase("pass") || ((String)obj).equalsIgnoreCase("fail") ))
		            	{
		            		 cell.setCellStyle(style);
		            	}
		            	
		            }
		                
		            else if(obj instanceof Double)
		                cell.setCellValue((Double)obj);
		        }
		    }
		    try {
		        FileOutputStream out =new FileOutputStream(new File("TestResult.xls"));
		        workbook.write(out);
		        out.close();
		        System.out.println("Excel written successfully..");
		         
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    //close the browser
		    driver.quit();
		  }
	
	private void handleErrorCondition(Exception e)
	{
		
    	System.out.println("Error"+e.getMessage());
    	
    	Writer writer = new StringWriter();
    	PrintWriter printWriter = new PrintWriter(writer);
    	e.printStackTrace(printWriter);
    	
    	//add fail entry to the excel sheet
    	 
         font.setColor(HSSFColor.RED.index);
         style.setFont(font);
      testresultdata.put("2", new Object[] {1d, "navigate to site and login","", "site opens and login successful","Site opens and login not successful","Fail",writer.toString()});
     
       
        try {
			getscreenshot();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	}
