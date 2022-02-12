import java.awt.Button;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TestePaginaWebJumper {

	private WebDriver driver;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		// driver.manage().window().maximize();
		driver.get("https://wejump-automation-test.github.io/qa-test/");
	}

	@After
	public void finaliza() {
		driver.quit();
	}


	@Test
	public void cenario1() {
//		WebDriver driver = new ChromeDriver();

//		CEN�RIO 1
//		Crie um cen�rio onde clicamos nos bot�es "One", "Two, e "Four", depois 
//		verifique a aus�ncia dos mesmos.		
//		driver.manage().window().maximize();		
//		driver.get("https://wejump-automation-test.github.io/qa-test/");

		driver.findElement(By.id("btn_one")).click();
		driver.findElement(By.id("btn_two")).click();
		driver.findElement(By.id("btn_link")).click();
		Assert.assertFalse(driver.findElement(By.id("btn_one")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("btn_two")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("btn_link")).isSelected());

//		CEN�RIO 2		
// 		Dentro da mesma p�gina, clique nos bot�es "One",
//		"Two" e "Four" que encontram-se dentro do painel
//		"IFRAME BUTTONS" e valide a n�o-presen�a dos mesmos.

		driver.switchTo().frame(0);
		driver.findElement(By.id("btn_one")).click();
		driver.findElement(By.id("btn_two")).click();
		driver.findElement(By.id("btn_link")).click();
		Assert.assertFalse(driver.findElement(By.id("btn_one")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("btn_two")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("btn_link")).isSelected());
		// driver.quit();

	}

//		CENARIO 3
// 		No cen�rio final, iremos preencher o campo "YourFirstName" 
//		com um texto qualquer. Clique no bot�o "One", cheque a 
//		op��o "OptionThree", selecione a op��o "ExampleTwo" dentro 
//		da select box, e valide a presen�a da imagem do logo do "Selenium Webdriver".

	@Test
	// @Ignore
	public void cenariofinal() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wejump-automation-test.github.io/qa-test/");
		driver.findElement(By.id("first_name")).sendKeys("Miller Cardoso Barros");
		driver.findElement(By.id("btn_one")).click();
		driver.findElement(By.id("opt_three")).click();
		Assert.assertTrue(driver.findElement(By.id("opt_three")).isSelected());
		WebElement element = driver.findElement(By.id("select_box"));
		Select combo = new Select(element);
		combo.selectByVisibleText("ExampleTwo");
		driver.findElements(By.xpath("//div[@id=\'panel_body_three\']/img[4]"));

	}
}
