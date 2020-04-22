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

public class CoronaUpdateAndTelevisitLinkTest extends BaseTest {

	String testName = "CoronaUpdateAndTelevisitLinkTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void coronatelevisitlink(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "CoronaUpdateAndTelevisitLinkTest");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");
		// check the link on the corona update and televisit  button
		//click("coronaupdate_xpath");
		getUrlTitle("coronaupdate_xpath");
		//televisit
		click("televisit_xpath");
		verifyTextPresent("televisittext_xpath");
		
		
	}

	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}

}
