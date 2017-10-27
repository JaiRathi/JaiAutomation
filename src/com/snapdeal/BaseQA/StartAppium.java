package com.snapdeal.BaseQA;
	import java.net.MalformedURLException;
	import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.*;

	public class StartAppium   {
	static public WebDriver driver;
	
	@BeforeSuite
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Chrome");
		capabilities.setCapability("VERSION", "7.0.2"); 
		capabilities.setCapability("deviceName","SamsungEdge6");
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage", "com.snapdeal.main");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.snapdeal.ui.material.activity.MaterialMainActivity");
	//Create RemoteWebDriver instance and connect to the Appium server
	 	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 	   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	 	   
	}


	@AfterSuite
	public void teardown(){
		//close the app
		driver.quit();
	}
//	
//	@DataProvider(name="testdata")
//	public Object[][] passData(){
//		ReadGuru99ExcelFile reader = new ReadGuru99ExcelFile(System.getProperty("user.dir") + "//src//com//snapdeal//testdata//testdata.xlsx");
//		int rows=reader.getRowCount(0);
//	Object[][] data = new Object[rows][2];
//	for (int i=0; i<rows; i++){
//		data[i][0]=reader.getData(0, i, 0);
//		data[i][1]=reader.getData(0, i, 1);
//		
//	}
//	return data;
//	
//	}
	
	}


