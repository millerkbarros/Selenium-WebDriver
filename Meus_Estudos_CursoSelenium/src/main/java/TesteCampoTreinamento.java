import java.awt.Button;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
//	driver.manage().window().maximize();		
//	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
//	comando para digitar em um determinado campo
//	comando para verificar o que está digitado	
	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1296, 800));
		driver.get("https://wejump-automation-test.github.io/qa-test/");
		driver.findElement(By.id("first_name")).sendKeys("Miller");
		Assert.assertEquals("Miller", driver.findElement(By.id("first_name")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextAreo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://wejump-automation-test.github.io/qa-test/");
		driver.findElement(By.id("mid_name")).sendKeys("Cardoso");
		Assert.assertEquals("Cardoso", driver.findElement(By.id("mid_name")).getAttribute("value"));
		
	}
}
