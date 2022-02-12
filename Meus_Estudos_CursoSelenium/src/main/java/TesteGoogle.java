import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {

	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("http://www.google.com");
	}

	@Test
	public void teste() {
	//	System.setProperty("webdriver.gecko.driver", "/C/drivers_curso/geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
	//	WebDriver driver = new ChromeDriver();
	//	WebDriver driver = new InternetExplorerDriver();
	//	driver.manage().window().maximize();		
	//	driver.get("http://www.google.com");
	// 	Assert.assertEquaLs = (compara dois elementos, dois textos)
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
		.sendKeys("Linkedin" + Keys.ENTER);
		
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void teste2() {
	//	System.setProperty("webdriver.gecko.driver", "/C/drivers_curso/geckodriver.exe");
	//	WebDriver driver = new FirefoxDriver();
	//	WebDriver driver = new ChromeDriver();
	//	WebDriver driver = new InternetExplorerDriver();
	//	driver.manage().window().maximize();		
	//	driver.get("http://www.google.com");
	// 	Assert.assertEquaLs = (compara dois elementos, dois textos)
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
		.sendKeys("Mercado Livre" + Keys.ENTER);
		
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
