package com.stonerisehealthcare.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.stonerisehealthcare.base.BaseTest;
import com.stonerisehealthcare.utility.DataUtil;
import com.stonerisehealthcare.utility.Xls_Reader;

public class OtherServicesLinksTest extends BaseTest {
	String testName = "OtherServicesLinksTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void otherserviceslinks(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "OtherServicesLinksTest");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");
		click("otherservices_xpath");
		getUrlLinkTitle("stoneriseathome_xpath");	
		urlTitleMultiWindows("senioradvantage_xpath");
		/*
		 * click("senioradvantage_xpath"); switchtoWindow();
		 * System.out.println("The given link navigates to "+driver.getTitle());
		 */
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}

}
