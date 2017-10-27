package com.snapdeal.BaseQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadPropertyFile {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static FileInputStream fis ;
	
	public ReadPropertyFile(WebDriver driver) throws Exception {
		this.driver = driver;
		try {
			fis= new FileInputStream(System.getProperty("user.dir")+"/src/com/snapdeal/properties/ORHomePage.properties");	
			OR.load(fis);

			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public String getSearch(){
	return OR.getProperty("SearchField");
}
public String getLeftNavButton(){
	return OR.getProperty("LeftNavButton");
}
public String getClicklogin(){
	return OR.getProperty("Clicklogin");
}
public String loginMobilePageHeader(){
    return OR.getProperty("SnapdealLoginPageHeader");
}
    public String placeholderLoginField(){
    	 return OR.getProperty("PlaceholderLoginField");
    }
    public String loginField(){
   	 return OR.getProperty("LoginField");
	}
    public String clickContinoueLoginBtn(){
      	 return OR.getProperty("LoginContinouebButton");
   	}
    public String loginPageHeader(){
     	 return OR.getProperty("LoginPageHeader");
  	}
    public String passwordPlaceHolder(){
    	 return OR.getProperty("PasswordPlaceHolder");
 	} 
    public String passwordField(){
   	 return OR.getProperty("PasswordField");
	}
    public String ClickloginBtn(){
      	 return OR.getProperty("LoginBtn");
   	}
    
}


