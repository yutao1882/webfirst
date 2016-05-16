package com.yt;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.log4testng.Logger;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionType;
import br.eti.kinoshita.testlinkjavaapi.model.Attachment;
import br.eti.kinoshita.testlinkjavaapi.model.ReportTCResultResponse;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class APIObject {
	private static Logger logger = Logger.getLogger(APIObject.class);
	private static TestLinkAPI api = null;
	private String planName;
	private String projectName;
	private String url;
	private String devKey;
	private TestCase[] tcs;
	private TestPlan tl;
	private String buildName;
	private String platformName;

	private Integer tcID = 0;
	private Integer planID = 0;
	private TestCase tcase;

	public APIObject(String url, String devKey, String projectName,
			String planName, String buildName, String platformName) {
		this.url = url;
		this.devKey = devKey;
		this.projectName = projectName;
		this.planName = planName;
		this.buildName = buildName;
		this.platformName = platformName;
	}

	public TestLinkAPI getAPI() {
		if (null == api) {
			try {
				api = new TestLinkAPI(new URL(url), devKey);
			} catch (TestLinkAPIException te) {
				logger.error(te.getMessage(), te);
			} catch (MalformedURLException mue) {
				logger.error(mue.getMessage(), mue);
			}
		}
		return api;
	}

	public void getTestCases() {
		tl = api.getTestPlanByName(planName, projectName);
		System.out.println(planName);
		System.out.println(projectName);
		System.out.println(tl.getId());
		tcs = api.getTestCasesForTestPlan(tl.getId(), null, null, null, null,
				null, null, null, ExecutionType.MANUAL, false, null);
//		for (TestCase tc : tcs) {
//			System.out.println("111111111111111");
//			System.out.println(tc.toString());
//			System.out.println(tc.getName());
//			System.out.println("222222222222222");
//		}

	}

	public void executeTestCase(String testcasename, int status, String comments) {
		Integer planID = tl.getId();

		for (TestCase tc : tcs) {
			String casename = tc.getName();
			if (casename.equals(testcasename)) {
				tcID = tc.getId();
				tcase = tc;
				break;
			}

		}

		switch (status) {
		case 1:
			api.reportTCResult(tcID, null, planID, ExecutionStatus.PASSED,
					null, buildName, comments, null, null, null, platformName,
					null, null);
			break;
		case 2:
			api.reportTCResult(tcID, null, planID, ExecutionStatus.FAILED,
					null, buildName, comments, null, null, null, platformName,
					null, null);
			break;
		case 3:
			api.reportTCResult(tcID, null, planID, ExecutionStatus.BLOCKED,
					null, buildName, comments, null, null, null, platformName,
					null, null);
			break;
		default:
			System.out.println("please check your status");
		}

	}

	public void uploadAttchment(String picturePath) {
		File attachmentFile = new File(picturePath);
		String fileContent = null;

		try {
			byte[] byteArray = FileUtils.readFileToByteArray(attachmentFile);
			fileContent = new String(Base64.encodeBase64(byteArray));
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}

		Attachment attachment = api.uploadExecutionAttachment(31, // executionid
				"ScreenshotFor this Test case-", // title
				"In this screen the attendant is defining the customer plan", // description
				"Autor:luter2", // fileName
				"image/jpg", // fileType
				fileContent); // content

		System.out.println("Attachment uploaded");
	}

	public static void main(String args[]) {
		// the following settings are required;
		String url = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
//		String devKey = "c3b0237ea2aa5e4c65bc43542c1b5f20";// "yutao";
		String devKey = "15454d30dbd79f0c311e7a4c19c04855";// "admin";
		String projectName = "HiGame";
		String tl = "海海游戏平台3.5.6功能测试";
		String buildName = "higame第二个build";
		String platform = "win7 chrome";

		APIObject testlinkapi = new APIObject(url, devKey, projectName, tl,
				buildName, platform);
		testlinkapi.getAPI();
		testlinkapi.getTestCases();

		testlinkapi.executeTestCase("case001", 1,
				"The test case is passed on 8.30");
		// testlinkapi.uploadAttchment("C:\\12\\te.jpg");
		// System.out.println(testlinkapi.tcase.getFullExternalId());
		// testlinkapi.tcase.getExecutionOrder()

	}
}
