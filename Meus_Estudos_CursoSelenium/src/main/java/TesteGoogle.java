import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
	//	System.setProperty("webdriver.gecko.driver", "/C/drivers_curso/geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
	//	WebDriver driver = new InternetExplorerDriver();
	//	driver.manage().window().maximize();		
		driver.get("http://www.google.com");
	// 	Assert.assertEquaLs = (compara dois elementos, dois textos)	
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
