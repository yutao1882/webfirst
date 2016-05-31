package com.yt;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class TestBrowsers {

	private WebDriver driver;
	
	 //testlink parameters
    private String url = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    private String devKey = "15454d30dbd79f0c311e7a4c19c04855";
    private String projectName = "HiGame";
    private String tl = "海海游戏平台3.5.6功能测试";
    private String buildName = "higame第二个build";
    private String platform = "win7 chrome";
	private APIObject testlinkapi;
	private String caseName;

	@BeforeClass
	public void beforeClass() {
//		Browsers browsers = new Browsers(BrowsersType.chrome);
//		driver = browsers.driver;
		//init testlink object
		testlinkapi = new APIObject(url,devKey,projectName,tl,buildName,platform);
//		System.out.println("===========@BeforeClass=========");
	}

	@Test
	public void start() throws InterruptedException {
		System.out.println("==========@Test===TestBrowsers=======");
		caseName = "case001";
//		driver.get("https://yuntest.haihaigame.com/login");
		Assert.assertEquals(true, true);
		Thread.sleep(1000);
		
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
	
	@AfterMethod
	public void import2TestLink(ITestResult result) throws Exception {  	
//    	testlinkapi.getAPI();
//    	testlinkapi.getTestCases();
//    	testlinkapi.executeTestCase(caseName,result.getStatus(),"");
	}

}
