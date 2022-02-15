
import java.awt.Button;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class TestPaginaBase2Camp {

	private WebDriver driver;

	@Before
	public void inicializa() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.pipefy.com/public/form/pITmZMtR");
		
	}
	
	@Test
	public void teste() {
		
		//Localizar logo Base2</>CAMP
		
		
		//Abrir Formulário de Candidatura ao Base2Camp 
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(800, 800));
		//driver.get("https://app.pipefy.com/public/form/pITmZMtR");
		
		//Preencher campo (Nome completo)
		driver.findElement(By.name("customFields.nome_do_candidato")).sendKeys("Miller Cardoso Barros");
		Assert.assertEquals("Miller Cardoso Barros", driver.findElement(By.name("customFields.nome_do_candidato")).getAttribute("value"));
		
		//Preencher campo (E-mail)		
		driver.findElement(By.name("customFields.e_mail_do_candidato_1")).sendKeys("millerkbarros@gmail.com");
		Assert.assertEquals("millerkbarros@gmail.com", driver.findElement(By.name("customFields.e_mail_do_candidato_1")).getAttribute("value"));

		//Preencher campo (Linkedin)
		driver.findElement(By.name("customFields.linkedin")).sendKeys("https://www.linkedin.com/in/miller-c-a6a514227/");		
		Assert.assertEquals("https://www.linkedin.com/in/miller-c-a6a514227/", driver.findElement(By.name("customFields.linkedin")).getAttribute("value"));
		
		//Preencher campo (Telefone / WhatsApp)
		driver.findElement(By.id("phone-field-id-Telefone / WhatsApp")).sendKeys("(22) 99748-9113");
		Assert.assertEquals("(22) 99748-9113", driver.findElement(By.id("phone-field-id-Telefone / WhatsApp")).getAttribute("value"));

		//Preencher campo (De onde você é?)
		driver.findElement(By.name("customFields.de_onde_voc")).click();
	    WebElement dropdown = driver.findElement(By.name("customFields.de_onde_voc"));
	    dropdown.findElement(By.xpath("//option[. = 'Rio de Janeiro e região metropolitana, RJ']")).click();
		
	    //outra maneira de selecionar um valor no COMBO(BOX)
		//WebElement element = driver.findElement(By.name("customFields.de_onde_voc"));
		//Select combo = new Select(element);
		//combo.selectByIndex(19);
	    //combo.selectByValue("Rio de Janeiro e região metropolitana, RJ");
			
	    
	    //Preencher campo (Como ficou sabendo sobre o Base2Camp?)
	    driver.findElement(By.name("customFields.nome_de_quem_indicou")).sendKeys("Linkedin");
	    Assert.assertEquals("Linkedin", driver.findElement(By.name("customFields.nome_de_quem_indicou")).getAttribute("value"));
	           
	    //Já atua com TI? Se sim, em qual área? 
	    driver.findElement(By.name("customFields.j_atua_com_ti_se_sim_em_qual_rea")).click();
	    WebElement dropdown11 = driver.findElement(By.name("customFields.j_atua_com_ti_se_sim_em_qual_rea"));
	    dropdown11.findElement(By.xpath("//option[. = 'Analista de Testes Manuais']")).click();
		
	    //Preencher campo (Qual a sua senioridade?) 
	    driver.findElement(By.name("customFields.qual_a_sua_senioridade")).click();
	    WebElement dropdown1 = driver.findElement(By.name("customFields.qual_a_sua_senioridade"));
	    dropdown1.findElement(By.xpath("//option[. = 'Pleno']")).click();
		
		//Preecher campo (Pretensão salarial)
	    driver.findElement(By.name("customFields.pretens_o_salarial")).sendKeys("0,00");
	    Assert.assertEquals("0,00", driver.findElement(By.name("customFields.pretens_o_salarial")).getAttribute("value"));
		
		//Localizar botão (Solte arquivos para anexar, ou Busque)
	    driver.findElement(By.xpath("//div[@id=\'dropzone-fake-pipe-field-publicForm-customFields_curr_culo-input\']/div[2]/div/a/span"));
	    
	    //Localizar botão (Enviar)
	    driver.findElement(By.xpath("//button[contains(.,'Enviar')]"));
	    
	    //Retornar ao campo (Nome Completo)
	    driver.findElement(By.name("customFields.nome_do_candidato")).click();
	    		    
	    //Fechar o browser
	    //driver.quit();
	    //driver.close();
	}
}
