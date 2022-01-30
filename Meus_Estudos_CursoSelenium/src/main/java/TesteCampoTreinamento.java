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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
//	driver.manage().window().maximize();		
//	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
//	comando para digitar em um determinado campo
//	comando para verificar o que está digitado	
	@Test
	public void testeTextField(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Miller Cardoso Barros");
		Assert.assertEquals("Miller Cardoso Barros", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextAreo(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("campo sugestão");
		Assert.assertEquals("campo sugestão", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void deveInteragirComRadioButton(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo")).isSelected());
		driver.quit();
		
	}

	@Test
	public void deveInteragirComCheckBox(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
		
		
		
		
	}

}
