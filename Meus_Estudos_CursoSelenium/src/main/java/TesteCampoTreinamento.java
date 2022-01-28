import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteCampoTreinamento {
	
	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
		
				
//		driver.quit();
	}
}
