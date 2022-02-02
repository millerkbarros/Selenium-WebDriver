import java.awt.Button;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Ignore;
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
	
private List<WebElement> allSelectedOptions;


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

	@Test
	public void deveInteragirComCombo(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(5);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
		
//		driver.findElement(By.id("elementosForm:escolaridade")).click();
//		WebElement dropdown = driver.findElement(By.id("elementosForm:escolaridade"));
//		dropdown.findElement(By.xpath("//*[@id=\"elementosForm:escolaridade\"]/option[6]")).click();
			
	}

	@Test
	public void deveVerificarValoresCombo(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

//		Verificar se alguma determinada opção está disponível no COMBO				
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado"));
				encontrou = true;
				break;
			
		}
		Assert.assertTrue(encontrou);
	}


	@Test
	public void deveVerificarValoresComboMultiplo(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
	
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
//		desmarcar uma das opções do COMBO
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	@Ignore 
	public void deveInteragirComLinks(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou", driver.findElement(By.id("resultado")).getText());
		
}
	//Elementos básicos: Div e Span
	@Test
	public void deveBuscarTextosNaPagina(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//					.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento",
					driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
					driver.findElement(By.className("facilAchar")).getText());
		driver.quit();
	}
}















