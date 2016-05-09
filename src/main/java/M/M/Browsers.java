package M.M;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers { 
//aaaggghhhdd
	public WebDriver driver = null;
	private FirefoxProfile firefoxProfile = null;
	private static DesiredCapabilities caps = null;
	private String porjectPath = System.getProperty("user.dir");
	
	

	public Browsers(BrowsersType browsersType) {
		System.out.println(porjectPath);
		switch (browsersType) {
		case firefox:
			File firebug = new File(porjectPath + "");
			File firepath = new File(porjectPath + "");
			firefoxProfile = new FirefoxProfile();
			try {
				firefoxProfile.addExtension(firebug);
				firefoxProfile.addExtension(firepath);
				firefoxProfile.setPreference("webdirver.accept.untrusted.certs", "true");
				firefoxProfile.setPreference("extension.firebug.currentVersion", "1.12.1");
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver = new FirefoxDriver(firefoxProfile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", porjectPath + "");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "private");
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			break;
		case chrome:
//			System.setProperty("webdriver.chrome.driver", porjectPath + "");
			System.setProperty("webdriver.chrome.driver", "D:\\myWorkspace\\M\\tools\\chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			driver = new ChromeDriver(caps);
			driver.manage().window().maximize();
			break;
		}

	}

}
