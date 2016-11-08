package util;

import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import testApps.DriverApp;


public class TestConfig{


	
	
	public static String testSiteURL = "http://www.payback.in/home.html";
	public static String testBrowser = "*chrome";
	public static String subject = "Test Report";

	public static String attachmentName="Error.jpeg";
	//public static String filepath="C:/Selenium3.0/app/test/Framework/testweb/WebContent/webpages";
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.168.1.165;DatabaseName=monitor_eval"; 
	public static String dbUserName=""; 
	public static String dbPassword=""; 
	
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "pasrd";
	public static String mysqlurl = "jdbc:mysql://192.168.1.165/monitor_dm";
	
	
}
