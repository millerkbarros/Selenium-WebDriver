import java.awt.Button;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
	
	private WebDriver driver;
	
	
	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}


	@Test
	public void testeTextField(){
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Miller Cardoso Barros");
		Assert.assertEquals("Miller Cardoso Barros", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComTextAreo(){
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("campo sugestão");
		Assert.assertEquals("campo sugestão", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	public void deveInteragirComRadioButton(){
		driver.findElement(By.id("elementosForm:sexo")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo")).isSelected());
	}

	@Test
	public void deveInteragirComCheckBox(){
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	public void deveInteragirComCombo(){
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
	}

	@Test
	public void deveVerificarValoresCombo(){
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
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	//@Ignore 
	public void deveInteragirComLinks(){
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou", driver.findElement(By.id("resultado")).getText());
		
}
	//Elementos básicos: Div e Span
	@Test
	public void deveBuscarTextosNaPagina(){
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//					.getText().contains("Campo de Treinamento"));
//		BUSCA POR TAG
		Assert.assertEquals("Campo de Treinamento",
					driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
					driver.findElement(By.className("facilAchar")).getText());
		driver.quit();
	}
}















