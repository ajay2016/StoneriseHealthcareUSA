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

public class Resources extends BaseTest {
	
	String testName = "Resources";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void otherserviceslinks(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "Resources");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");	
		click("resources_xpath");
			  
		 
		urlTitleMultiWindows("westvirginiahca_xpath");
		urlTitleMultiWindows("americanhca_xpath");
		getUrlLinkTitle("medicare_xpath");
		urlTitleMultiWindows("wvmedicaid_xpath");
		urlTitleMultiWindows("nationalaa_xpath");
		urlTitleMultiWindows("westvirginiaaa_xpath");
		urlTitleMultiWindows("hospiceinformation_xpath");
		urlTitleMultiWindows("nationalaarp_xpath");
		urlTitleMultiWindows("westvirginiaaarp_xpath");
		urlTitleMultiWindows("cancer_xpath");
		urlTitleMultiWindows("diabetes_xpath");
		urlTitleMultiWindows("heart_xpath");
		urlTitleMultiWindows("lung_xpath");
		urlTitleMultiWindows("arthritis_xpath");
		urlTitleMultiWindows("caregiver_xpath");
		urlTitleMultiWindows("wvendoflife_xpath");
		urlTitleMultiWindows("wvha_xpath");
		urlTitleMultiWindows("wvseniorservices_xpath");
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}

}
