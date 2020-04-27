package com.stonerisehealthcare.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.stonerisehealthcare.base.BaseTest;
import com.stonerisehealthcare.utility.DataUtil;


public class ContactAndConnectLinksTest extends BaseTest {

	//String testName = "ContactAndConnectLinksTest";
	//Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void otherserviceslinks(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "ContactAndConnectLinksTest");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");

		urlTitleMultiWindows("googlemaps_xpath");
		urlTitleMultiWindows("facebook_xpath");
		urlTitleMultiWindows("linkedin_xpath");

		getUrlTitle("telnumber_xpath");
		getUrlTitle("telnum1_xpath");
		/*
		 * contactPopupAndScreenshot("telnumber_xpath");
		 * contactPopupAndScreenshot("telnum1_xpath");
		 * 
		 */
	}

	/*
	 * @DataProvider public Object[][] getData() { xls = new
	 * Xls_Reader(prop.getProperty("xlsPath")); return DataUtil.getTestData(xls,
	 * testName); }
	 */

}
