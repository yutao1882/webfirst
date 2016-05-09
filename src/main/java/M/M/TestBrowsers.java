package M.M;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers {

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		Browsers browsers = new Browsers(BrowsersType.chrome);
		driver = browsers.driver;
		System.out.println("====================");

	}

	@Test
	public void start() throws InterruptedException {
		System.out.println("====================");
//		driver.get("https://yuntest.haihaigame.com/login");
		
		Thread.sleep(5000);

	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}

}
