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

public class SkilledNursingCentersLinksTest extends BaseTest {
	String testName = "SkilledNursingCentersLinksTest";
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void nursingcentreslinks(Hashtable<String, String> data) throws IOException {

		// gives data set
		test.log(Status.INFO, data.toString());

		if (!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Test skipped since rumode is N");
			throw new SkipException("Test skipped since rumode is N");

		}

		test.log(Status.INFO, "SkilledNursingCentersLinksTest");
		// opening chrome browser
		openBrowser(data.get("Browser"));
		// navigate to given url
		navigate("appurl");
		click("skillednursingcenters_xpath");
		getUrlLinkTitle("mapleshire_xpath");
		getUrlLinkTitle("pineridge_xpath");
		getUrlLinkTitle("riveroaks_xpath");
		getUrlLinkTitle("meadowview_xpath");
		getUrlLinkTitle("eaglepointe_xpath");
		getUrlLinkTitle("carehaven_xpath");
		getUrlLinkTitle("berkeleysprings_xpath");
		getUrlLinkTitle("pineyvalley_xpath");
		getUrlLinkTitle("clarygrove_xpath");
		getUrlLinkTitle("eastbrook_xpath");
		getUrlLinkTitle("glewoodpark_xpath");
		getUrlLinkTitle("harpermills_xpath");
		getUrlLinkTitle("meadowgarden_xpath");
		getUrlLinkTitle("springfield_xpath");
		getUrlLinkTitle("valleyhaven_xpath");
		getUrlLinkTitle("moundview_xpath");
		
		
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		xls = new Xls_Reader(prop.getProperty("xlsPath"));
		return DataUtil.getTestData(xls, testName);
	}
}
