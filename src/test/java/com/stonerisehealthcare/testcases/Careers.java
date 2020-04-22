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

public class Careers extends BaseTest {
	
	String testName = "CareersLinkTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void careerslink(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "CareersLinkTest");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");
		click("careers_xpath");
		click("jobs_xpath");
		
		switchtoWindow();
		
		type("zipcode_xpath", data.get("Zipcode"));
		//click("jobtitle_xpath");
		//wait(2);
		//
		type("jobtitledetails_xpath", data.get("JobTitle"));
		click("anydistance_xpath");
		click("findjobs_xpath");
		String searchresult = verifyTextPresent("resultjobs_xpath");
		System.out.println("Search result for zipcode   "+data.get("Zipcode")+" is  " +searchresult);

		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}
	

}
