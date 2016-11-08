package testApps;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.ErrorCollectors;
import datatable.Xlfile_Reader;

public class Keywords extends DriverApp {
	
	   public static Random randomGenerator = new Random();
	   public static Calendar cal = new GregorianCalendar();  //used for adding current date in variable and then used in paths
	   public static int date = cal.get(Calendar.DATE);  //used for adding current date in variable and then used in paths
	   public static int month = cal.get(Calendar.MONTH);  //used for adding current date in variable and then used in paths
	   public static int year = cal.get(Calendar.YEAR);  //used for adding current date in variable and then used in paths
	   public static int sec =cal.get(Calendar.SECOND);  //used for adding current date in variable and then used in paths
	   public static int day =cal.get(Calendar.HOUR_OF_DAY);  //used for adding current date in variable and then used in paths
	   public static int hour=cal.get(Calendar.HOUR);  //used for adding current date in variable and then used in paths
	   public static int min=cal.get(Calendar.MINUTE);  //used for adding current date in variable and then used in paths
	   public static String sMin = new Integer(randomGenerator.nextInt(60)).toString(); //Converted Integer value to String and then used in paths
	   public static String sSec=new Integer(randomGenerator.nextInt(60)).toString(); //Converted Integer value to String and then used in paths
	   public static String sHour=new Integer(randomGenerator.nextInt(24)).toString();  //Converted Integer value to String and then used in paths
	   public static String sDate=new Integer(date).toString();  //Converted Integer value to String and then used in paths
	   public static String call_id ; //Used in GetText() and DBQuerycheck() to store the call id to be used for Eval UI
	   public static String sUser=null;
	   public static String sUser_Name;
	   public static Xlfile_Reader datareader=null;
	   public static Xlfile_Reader datawriter=null;
	   public static float round;
	   public static float round1;
       public static String script_error=null;
	   public static int globalwait;
	   static WebDriverWait wait = new WebDriverWait(driver,60);
	   
	//Navigate to the current URL
	   
	public static String navigate() throws Throwable{
		APPLICATION_LOGS.debug("Executing Navigate");
		try{
			driver.get(CONFIG.getProperty(object));
				    
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while navigating -"+ object + t.getMessage());
					   
		}
		return "Pass";
		
	}
	
	//Clicking on a link or an Object
	
	public static String clickLink(){
		APPLICATION_LOGS.debug("Executing clickLink");

		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
			driver.findElement(By.xpath(Objects.getProperty(object))).click();
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
			script_error = "Timed out after "+globalwait+" miliseconds";
			
		   return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	

	public static String scrolldown(){
		APPLICATION_LOGS.debug("Executing clickLink");
		try{
		
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			  //js.executeScript("window.scrollBy(0,-1000)");
			//  EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
			  //eventFiringWebDriver.executeScript("document.getElementById('mail_countrys').scrollBottom = 10000");
			  WebElement scroll = driver.findElement(By.xpath(Objects.getProperty(object)));
			  scroll.sendKeys(Keys.PAGE_DOWN);
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
			script_error = "Timed out after "+globalwait+" miliseconds";
			
		   return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	public static String scrollup(){
		APPLICATION_LOGS.debug("Executing clickLink");
		try{
		
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			  //js.executeScript("window.scrollBy(0,-1000)");
			//  EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
			  //eventFiringWebDriver.executeScript("document.getElementById('mail_countrys').scrollBottom = 10000");
			  WebElement scroll = driver.findElement(By.xpath(Objects.getProperty(object)));
			  scroll.sendKeys(Keys.PAGE_UP);
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
			script_error = "Timed out after "+globalwait+" miliseconds";
			
		   return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	
	public static String clicklink(){
		APPLICATION_LOGS.debug("Executing clickLink");
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
		driver.findElement(By.id(Objects.getProperty(object))).click();
		APPLICATION_LOGS.debug("Executing clickLink");
		}catch(Throwable t){
			
			// Report error in Application logs
			APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
			script_error = "Timed out after "+globalwait+" miliseconds";
			
		   return "Fail - Link Not Found";
		}
		
		return "Pass";
	}
	
	
	//Clicking on an Object
	
		public static String click(){
			APPLICATION_LOGS.debug("Executing click");
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
				driver.findElement(By.id(Objects.getProperty(object))).click();
			}catch(Throwable t){
				
				// Report error in Application logs
				APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
				script_error = "Timed out after "+globalwait+" miliseconds";
				
			   return "Fail - Object Not Found";
			}
			
			return "Pass";
		}
		
		//Clicking on an Object
		
		public static String Click(){
			APPLICATION_LOGS.debug("Executing click");
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
				driver.findElement(By.xpath(Objects.getProperty(object))).click();
			}catch(Throwable t){
				
				// Report error in Application logs
				APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
				script_error = "Timed out after "+globalwait+" miliseconds";
				
			   return "Fail - Object Not Found";
			}
			
			return "Pass";
		}
		
		public static String cLick(){
			APPLICATION_LOGS.debug("Executing click");
			try{
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
				By selectElementSelector=(By) driver.findElement(By.cssSelector(".drpDwn.autoSugg.autoSuggestCountries.jspScrollable")).findElement(By.xpath("//li[contains(text(),'India')]"));
				wait.until(ExpectedConditions.presenceOfElementLocated(selectElementSelector)).click();
				//diver.findElement(By.id(Objects.getProperty(object))).click();
			}catch(Throwable t){
				
				// Report error in Application logs
				APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
				script_error = "Timed out after "+globalwait+" miliseconds";
				
			   return "Fail - Object Not Found";
			}
			
			return "Pass";
		}
	
	//Input data Keyword
	
		public static String input() throws Exception {
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			String message = "pass";
			
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
				driver.findElement(By.id(Objects.getProperty(object))).sendKeys(data);
				//System.out.println("Input keyword data :"+data);
			 
				}catch(Exception t){
					// report error
				APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
					
				script_error = "Timed out after "+globalwait+" miliseconds";
				
				
				}
				return "Pass";
				
		}
		
public static String tab() {
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			//String message = "pass";
			
			//String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
				//driver.findElement(By.id(Objects.getProperty(object))).sendKeys(Keys.TAB);
			//	driver.findElement(By.id(Objects.getProperty(object))).sendKeys(Keys.ENTER);
				WebElement e = driver.findElement(By.id(Objects.getProperty(object)));
				//using Keys.TAB
				e.sendKeys(Keys.TAB);
				e.sendKeys(Keys.ENTER);
				//System.out.println("Input keyword data :"+data);
			 
				}catch(Exception t){
					// report error
				APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
					
				script_error = "Timed out after "+globalwait+" miliseconds";
				
				//throw t;
				//return "Fail - "+t.getMessage();
					
				}
				return "Pass";
				
		}
	
public static String Input() throws Exception{
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			String message = "pass";
			
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));	
				driver.findElement(By.xpath(Objects.getProperty(object))).sendKeys(data);
				//System.out.println("Input keyword data :"+data);
			 
				}catch(Exception t){
					// report error
				APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
					
				script_error = "Timed out after "+globalwait+" miliseconds";
				
				//throw t;
				//return "Fail - "+t.getMessage();
					
				}
				return "Pass";
				
		}
	
	//Implement Wait
	
	public static String waitfor(){
	     APPLICATION_LOGS.debug("Executing wait Keyword");
	  // extract the test data
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			try{
				 
				float test = (Float.parseFloat(data));
				int test1 = (int) test;
				Thread.sleep(test1);
				globalwait = test1/1000;
			}catch(Throwable t){
				APPLICATION_LOGS.debug("Error while waiting -"+ object + t.getMessage());
			    return "Fail - "+t.getMessage();
							}
	     return "Pass";
	}
	
	
    //Clicking on a Button
	
	public static String clickButton(){
		APPLICATION_LOGS.debug("Executing clickButton Keyword");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
		driver.findElement(By.xpath(Objects.getProperty(object))).click();
		try{
						
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	public static String clickbutton(){
		APPLICATION_LOGS.debug("Executing clickutton Keyword");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
		driver.findElement(By.id(Objects.getProperty(object))).click();
		
		try{
						
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
//	Selecting text elements from Drop down list
	
	public static String select(){
		APPLICATION_LOGS.debug("Executing select Keyword");
		
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
        driver.findElement(By.xpath(Objects.getProperty(object)));
		Select oselection2 = new Select(driver.findElement(By.xpath(Objects.getProperty(object))));
		//oselection2.selectByVisibleText(data);
		oselection2.selectByValue(data);
		try{
			
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
			
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	public static String Select(){
		APPLICATION_LOGS.debug("Executing select Keyword");
		
		// extract the test data
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
        //driver.findElement(By.id(Objects.getProperty(object)));
		Select oselection2 = new Select(driver.findElement(By.id(Objects.getProperty(object))));
		oselection2.selectByVisibleText(data);
		//oselection2.selectByValue(data);
		try{
			
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
			
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
		// Clicking on a object by checkBox keyword
	
	public static String checkBox(){
		APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
		
		try{
					
			//String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
			//driver.findElement(By.xpath(Objects.getProperty(object))).click();
			WebElement element=driver.findElement(By.xpath(Objects.getProperty(object)));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	public static String CheckBox(){
		APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
		
		
		try{
					
			//String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
			WebElement element=driver.findElement(By.id(Objects.getProperty(object)));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
			/*if ( !driver.findElement(By.id(Objects.getProperty(object))).isSelected() )
			{
				driver.findElement(By.id(Objects.getProperty(object))).click();
			}*/
		
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	/* Verifying Text Presence - verifyText*/
	
	public static String verifyText(){
        APPLICATION_LOGS.debug("Executing verifyText");
        String expected=APPTEXT.getProperty(object);
        String actual=driver.findElement(By.xpath(Objects.getProperty(object))).getText();
        APPLICATION_LOGS.debug(expected);
        APPLICATION_LOGS.debug(actual);
        try{
            Assert.assertEquals(actual.trim() , expected.trim());
        }catch(Throwable t){
            // error
            APPLICATION_LOGS.debug("Error in text - "+object);
            APPLICATION_LOGS.debug("Actual - "+actual);
            APPLICATION_LOGS.debug("Expected -"+ expected);
            return "Fail -"+ t.getMessage();
           
        }
       
        return "Pass";
    
   }
	
	public static String softAssertTrue() throws Exception{
		
		APPLICATION_LOGS.debug("Executing input Keyword");
		// extract the test data
		String message = "pass";
		String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		
		
		try{
				System.out.println("Assert keyword data :"+data);
				System.out.println(driver.findElement(By.xpath(Objects.getProperty(object))).getText());
				ErrorCollectors.verifyEquals(driver.findElement(By.xpath(Objects.getProperty(object))).getText(), data);
				System.out.println("Data matches expected was : "+driver.findElement(By.xpath(Objects.getProperty(object))).getText());
			}catch(Exception t){
				// report error
				System.out.println("Inside catch");
				APPLICATION_LOGS.debug("Error while wrinting into input -"+ object + t.getMessage());
				
				script_error = "Timed out after "+globalwait+" miliseconds";
				
				return "Fail - "+t.getMessage();
							
			}
			
		
			return "Pass";
			
			
	}
	
	
	//verifyTextOnThePage
			public void verifyTextOnThePage (String expected) throws InterruptedException{
				final WebDriverException exception =new WebDriverException();
				try{
						if(driver.findElement(By.xpath(Objects.getProperty(object))).getText().contains(expected)){
						System.out.println(expected +" text is on this page");
				}
				else{
						System.out.println(expected +" text is NOT on this page");
						throw new WebDriverException(exception.getMessage());
				}
				
				}
					    catch (WebDriverException e) {
				     	throw new WebDriverException(e.getMessage());
				}
				
			} 
			
			 public static String selectkeyboard(){
		            APPLICATION_LOGS.debug("Executing select Keyword");
		            // extract the test data
		            String data =testData.getCellData(currentTest, data_column_name , testRepeat);
		            
		            
		            
		            try{
		                WebElement webElement = driver.findElement(By.id("Objects.getProperty(object)"));
		                webElement.sendKeys(Keys.ENTER);
		                }catch(Throwable t){
		                    // report error
		                    APPLICATION_LOGS.debug("Error while Selecting from droplist -"+ object + t.getMessage());
		                    return "Fail - "+t.getMessage();
		                }
		                
		                return "Pass";
		        }
			 public static String jsclick(){
					APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
					
					
					try{
								
						//String data =testData.getCellData(currentTest, data_column_name , testRepeat);
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Objects.getProperty(object))));
						WebElement element=driver.findElement(By.xpath(Objects.getProperty(object)));
						((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
						/*if ( !driver.findElement(By.id(Objects.getProperty(object))).isSelected() )
						{
							driver.findElement(By.id(Objects.getProperty(object))).click();
						}*/
					
					}catch(Throwable t){
							// report error
							APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
							return "Fail - "+t.getMessage();
						}
						
						return "Pass";
				}
			 public static String jsClick(){
					APPLICATION_LOGS.debug("Executing Dynamic element present Keyword");
					
					
					try{
								
						//String data =testData.getCellData(currentTest, data_column_name , testRepeat);
						wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));
						WebElement element=driver.findElement(By.id(Objects.getProperty(object)));
						((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
						/*if ( !driver.findElement(By.id(Objects.getProperty(object))).isSelected() )
						{
							driver.findElement(By.id(Objects.getProperty(object))).click();
						}*/
					
					}catch(Throwable t){
							// report error
							APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
							return "Fail - "+t.getMessage();
						}
						
						return "Pass";
				}
			 public static String navigateto()
				{
						APPLICATION_LOGS.debug("Executing clickutton Keyword");
						//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Objects.getProperty(object))));

						String data =testData.getCellData(currentTest, data_column_name , testRepeat);
						driver.get(data);
						
						
						try{
										
						}catch(Throwable t){
								// report error
								APPLICATION_LOGS.debug("Error while clicking on Button -"+ object + t.getMessage());
								return "Fail - "+t.getMessage();
							}
							
							return "Pass";
					}


}
