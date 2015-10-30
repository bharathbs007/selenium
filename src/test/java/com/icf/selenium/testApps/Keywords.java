package com.icf.selenium.testApps;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.icf.selenium.datatable.Xlfile_Reader;



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
		
		driver.findElement(By.xpath(Objects.getProperty(object))).click();
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
				driver.findElement(By.id(Objects.getProperty(object))).click();
			}catch(Throwable t){
				
				// Report error in Application logs
				APPLICATION_LOGS.debug("Error while clicking on an Object -"+ object + t.getMessage());
				script_error = "Timed out after "+globalwait+" miliseconds";
				
			   return "Fail - Object Not Found";
			}
			
			return "Pass";
		}
	
	//Input data Keyword
	
		public static String input() {
			
			APPLICATION_LOGS.debug("Executing input Keyword");
			// extract the test data
			String message = "pass";
			
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			
			try{
								
				driver.findElement(By.id(Objects.getProperty(object))).sendKeys(data);
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
		
		driver.findElement(By.xpath(Objects.getProperty(object))).click();
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
		driver.findElement(By.xpath(Objects.getProperty(object)));
		Select oselection2 = new Select(driver.findElement(By.xpath(Objects.getProperty(object))));
		oselection2.selectByVisibleText(data);
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
					
			String data =testData.getCellData(currentTest, data_column_name , testRepeat);
			driver.findElement(By.xpath(Objects.getProperty(object))).click();
		
		}catch(Throwable t){
				// report error
				APPLICATION_LOGS.debug("Error while checking -"+ object + t.getMessage());
				return "Fail - "+t.getMessage();
			}
			
			return "Pass";
	}
	
	
}
