package com.snapdeal.test;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.snapdeal.BaseQA.*;
import com.snapdeal.Pages.HomePage;
import com.snapdeal.Utility.Screenshot;
import com.snapdeal.testdata.Constant;
import com.snapdeal.testdata.ExcelUtils;

@Listeners(com.snapdeal.Reports.CustomeReport.class)


public class LoginTest extends StartAppium {

	@Test(priority=0)
	public void testSearch() throws Exception{
		HomePage homePage = new HomePage(driver);
			homePage.VerifyHomePage();

	}
	
	@Test(priority=1)
	public void testLoginHeader() throws Exception{
		HomePage homePage = new HomePage(driver);
		homePage.VerifyLoginOnPage();
		Screenshot.takeScreenShot(System.getProperty("user.dir")+"//Screenshots//","testLoginHeader");

	}
	
	@Test(priority=2)

	public void testLogin() throws Exception{
		HomePage homePage = new HomePage(driver);
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Login");
        String sUserName = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);

	      homePage.VerifyUserName(sUserName);

				homePage.VerifyPassword(sPassword);      
		        ExcelUtils.setCellData("Pass", 1, 3);

	}
	
	
	
//	  @DataProvider
//	  
//	    public Object[][] Authentication() throws Exception{
//			String path = System.getProperty("user.dir") + "//src//com//snapdeal//testdata//testdata.xlsx";
//
//	         Object[][] testObjArray = ExcelReader.getTableArray(path,"Login");
//	 
//	         return testObjArray;
//	 
//			}
	
//	@Test(priority=2, dataProvider="Authentication")
//	  public static void testLogin(String UserName, String Password) throws Exception {
//		
//		HomePage homePage = new HomePage(driver);
//		  homePage.VerifyUserName(UserName);
//					homePage.VerifyPassword(Password); 
//					}		
	
}
