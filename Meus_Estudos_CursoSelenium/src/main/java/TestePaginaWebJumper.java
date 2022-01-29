import java.awt.Button;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class TestePaginaWebJumper {
	
	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();		
//		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.get("https://wejump-automation-test.github.io/qa-test/");
		driver.findElement(By.id("first_name")).sendKeys("Miller");
		driver.findElement(By.id("mid_name")).sendKeys("Cardoso");
		driver.findElement(By.id("last_name")).sendKeys("Barros");
		driver.findElement(By.id("age")).sendKeys("35");
		driver.findElement(By.id("email")).sendKeys("millerkbarros@gmail.com");
		driver.findElement(By.id("job")).sendKeys("QA na Wejump");
		driver.findElement(By.id("gender")).sendKeys("masculino");
		driver.findElement(By.id("reset_fields")).click();
		driver.findElement(By.id("btn_one")).click();
		driver.findElement(By.id("btn_two")).click();
		driver.findElement(By.id("btn_three")).click();
		driver.findElement(By.id("btn_link")).click();
		driver.findElement(By.id("reset_buttons")).click();
//		driver.findElement(By.id("xpath=//input[@='opt_one']")).click();
	
		
							
//		driver.quit();
		
		
	}
}
