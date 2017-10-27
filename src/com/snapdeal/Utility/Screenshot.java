package com.snapdeal.Utility;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.snapdeal.BaseQA.StartAppium;

public class Screenshot extends StartAppium {
	static Calendar cal = new GregorianCalendar();
	static int date = cal.get(Calendar.DATE);
	static int month = cal.get(Calendar.MONTH);
	static int year = cal.get(Calendar.YEAR);
	static int sec = cal.get(Calendar.SECOND);
	static int min = cal.get(Calendar.MINUTE);
	static int day = cal.get(Calendar.HOUR_OF_DAY);

	public static void takeScreenShot(String location, String fileName) {

		File f1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f1, new File(location + "/" + fileName + "_"
					+ date + "_" + (month + 1) + "_" + (year) + "_" + (day)
					+ "_" + min + "_" + sec + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Reporter.log("<img src=\"file:///" + location + fileName + "\" alt=\"\"/><br/>");
	}

}