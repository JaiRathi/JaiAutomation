package com.snapdeal.Pages;

	
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

import com.snapdeal.BaseQA.ReadPropertyFile;

	public class HomePage {
		public static WebDriver driver;

		public HomePage(WebDriver driver) {
			this.driver = driver;


		}  
	
	public void VerifyHomePage() throws Exception {
		ReadPropertyFile OR= new ReadPropertyFile(driver);
			 WebElement results= driver.findElement(By.id(OR.getSearch()));
			if (results.getText().equals("Search for brands, products & categories")){
				 System.out.println("User reach at Home Page: " +"\n" +results.getText());  
				
			}else{
				 System.out.println("User reach at Home page and Search placeholder is: " +"\n" +results.getText());  

			}
			 WebElement result= driver.findElement(By.className(OR.getLeftNavButton()));
			 result.click();

			 driver.findElement(By.id(OR.getClicklogin())).click();

		}
	
		public void VerifyLoginOnPage() throws Exception{
			ReadPropertyFile OR= new ReadPropertyFile(driver);
			 WebElement results= driver.findElement(By.id(OR.loginMobilePageHeader()));
			 if (results.getText().equals("Please provide your Mobile Number to Login/Sign Up before you place the order")){
				 System.out.println("Login Header is differ: " +"\n" +results.getText());  
			 }else{
				 
				 System.out.println("Now Login Header is: " +results.getText());  
		
			}
		
			 
		}
		public void VerifyUserName(String userName) throws Exception{
			ReadPropertyFile OR= new ReadPropertyFile(driver);
			 WebElement result= driver.findElement(By.id(OR.placeholderLoginField()));
			 if (result.isDisplayed()){
             System.out.println("Mobile number Placeholder is present: " +result.getText());
 			driver.findElement(By.id(OR.loginField())).sendKeys(userName);
			//driver.findElement(By.id(OR.clickContinoueLoginBtn())).click();

		   }else{
            System.out.println("No Placehonlder is present in mobile field");

		}
	}	
	
		public void VerifyPassword(String password) throws Exception{
			ReadPropertyFile OR= new ReadPropertyFile(driver);
			 List<WebElement> loginheader= driver.findElements(By.id(OR.loginPageHeader()));
             System.out.println ("Header is present: " +loginheader.get(0).getText());
			 WebElement result= driver.findElement(By.id(OR.passwordPlaceHolder()));
			 if (result.isDisplayed()){
				 
	             System.out.println("Password Placeholder is present:" +result.getText());
	 			driver.findElement(By.id(OR.passwordField())).sendKeys(password);
				driver.findElement(By.id(OR.ClickloginBtn())).click();
			   }else{
	            System.out.println("No Placehonlder is present in password field");

			}
			

	}
	}
		
	
//		// this method will used to search flights
//		public void clickOnSearchbtn(String loc) {
//			driver.findElement(By.id(loc));
//
//		}
//
//		// this method will used to find flights along with fare
//		public void printFlightsList() {
//			List<WebElement> autoSuggest = driver
//					.findElements(By.xpath("//span[@class='make_blockElm airline_name append_bottom4 ng-binding']"));
//			List<WebElement> autoSuggest1 = driver
//					.findElements(By.xpath("//span[@class='make_blockElm price ng-binding ng-scope']"));
//			for (WebElement a : autoSuggest)
//				for (WebElement b : autoSuggest1)
//					System.out.println("Flight is = " + a.getText() + "\n" + "Fare is " + b.getText());
//		}
//
//		public WebElement tblCalendar;
//		public WebElement btnPrevious;
//		public WebElement btnNext;
//		public WebElement lblYear;
//		public WebElement lblMonth;
//
//		// this method will used to find date as per user choice
//		public void findTblCalendar() {
//			tblCalendar = driver.findElement(By.className("ui-datepicker-calendar"));
//		}
//
//		public void findbtnPrevious() {
//			btnPrevious = driver.findElement(By.xpath("//a[@title=\"Prev\"]"));
//		}
//
//		public void findbtnNext() {
//			btnNext = driver.findElement(By.xpath("//a[@title=\"Next\"]"));
//		}
//
//		public void findlblYear() {
//			lblYear = driver.findElement(By.className("ui-datepicker-year"));
//		}
//
//		public void findlblMonth() {
//			lblMonth = driver.findElement(By.className("ui-datepicker-month"));
//		}
//
//		public void SelectDateFromDatePicker(String year, String month, String date) {
//			findTblCalendar();
//			findbtnNext();
//			findbtnPrevious();
//			findlblMonth();
//			findlblYear();
//
//			while (!year.equalsIgnoreCase(lblYear.getText())) {
//				if (Integer.parseInt(year) < Integer.parseInt(lblYear.getText())) {
//					btnPrevious.click();
//				} else {
//					btnNext.click();
//				}
//			}
//
//			/*
//			 * while (! lblMonth.getText().equalsIgnoreCase("January")) {
//			 * btnPrevious.click(); }
//			 */
//
//			while (!month.equalsIgnoreCase(lblMonth.getText())) {
//				btnNext.click();
//			}
//
//			WebElement dateField = driver.findElement(By.xpath("//a[text()=\"" + date + "\"]"));
//			dateField.click();
//		}

//	public void SwipeRight(WebElement element){
//		Point eloc =  null;
//		MobileElement mobileElem = null;
//		int xStartIndex = 0;
//		int xEndIndex = 0;
//		int yIndex = 0;
//		try{
//			if(element!=null){
//				mobileElem = (MobileElement)element;
//				eloc = mobileElem.getLocation();
//				xStartIndex =  eloc.getX();
//				xStartIndex = (int) xStartIndex + 20;
//				xEndIndex = eloc.getX() + mobileElem.getSize().width;
//				xEndIndex  = (int)(eloc.getX() + mobileElem.getSize().width) - (eloc.getX() + mobileElem.getSize().width)/10;
//				yIndex = eloc.getY()+ mobileElem.getSize().getHeight()/2;
//			}
//			else{
//				Dimension screenSize = driver.manage().window().getSize();
//				xEndIndex = 20;
//				yIndex = screenSize.getHeight()/2;
//				xStartIndex = screenSize.getWidth() - 20;
//			}
//			driver.swipe(xEndIndex, yIndex, xStartIndex, yIndex, 500);
//		}
//		catch(Exception e1){
//			try{
//				MobileElement elem = (MobileElement) element;
//				elem.swipe(SwipeElementDirection.RIGHT, 200);
//			}
//			catch(Exception e3){
//				e3.printStackTrace();
//			}
//		}
//	}
//
//	public void SwipeLeft(WebElement element){
//		Point eloc =  null;
//		MobileElement mobileElem = null;
//		int xStartIndex = 0;
//		int xEndIndex = 0;
//		int yIndex = 0;
//		try{
//			if(element!=null){
//				mobileElem = (MobileElement)element;
//				eloc = mobileElem.getLocation();
//				xStartIndex =  eloc.getX();
//				xStartIndex = xStartIndex + 20;
//				xEndIndex = eloc.getX() + mobileElem.getSize().width;
//				xEndIndex  = (int)(eloc.getX() + mobileElem.getSize().width) - (eloc.getX() + mobileElem.getSize().width)/10;
//				yIndex = eloc.getY()+ mobileElem.getSize().getHeight()/2;
//			}
//			else{
//				Dimension screenSize = driver.manage().window().getSize();
//				xEndIndex = 20;
//				yIndex = screenSize.getHeight()/2;
//				xStartIndex = screenSize.getWidth() - 20;
//			}
//			driver.swipe(xStartIndex, yIndex, xEndIndex, yIndex, 500);
//		}
//		catch(Exception e1){
//			try{
//				MobileElement elem = (MobileElement) element;
//				elem.swipe(SwipeElementDirection.LEFT, 200);
//			}
//			catch(Exception e3){
//				e3.printStackTrace();
//			}
//		}
//	}



