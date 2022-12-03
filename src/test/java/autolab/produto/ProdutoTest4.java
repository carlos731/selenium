package autolab.produto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProdutoTest4 {
	private WebDriver driver;
	private String URL_BASE = "http://127.0.0.1:5500/produtos.html";//https://www.google.com
	private String PATH_DRIVE = "src\\test\\resources\\chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void produtoTesteCamposVazio() {
		//iniciar
		iniciar();
		
		//preparação
		WebElement btnCriar = driver.findElement(By.id("btn-adicionar"));
		WebElement inputCodigo = driver.findElement(By.id("codigo"));
		WebElement inputNome = driver.findElement(By.id("nome"));
		WebElement inputQuantidade = driver.findElement(By.id("quantidade"));
		WebElement inputValor = driver.findElement(By.id("valor"));
		WebElement inputData = driver.findElement(By.id("data"));
		WebElement inputSalvar = driver.findElement(By.id("btn-salvar"));
		WebElement inputSair = driver.findElement(By.id("btn-sair"));
		
		btnCriar.sendKeys(Keys.ENTER);
		btnCriar.sendKeys(Keys.ENTER);
		inputCodigo.sendKeys("1");
		inputNome.sendKeys("");
		inputQuantidade.sendKeys("2");
		inputValor.sendKeys("400");
		inputData.sendKeys("02122022");
		inputSalvar.sendKeys(Keys.ENTER);
		String resultado = driver.findElement(By.id("mensagem")).getText();
		System.out.println(resultado);
		inputSair.sendKeys(Keys.ENTER);
	
		
		assertTrue(resultado, resultado.contains("Todos os campos são obrigatórios para o cadastro!"));
	}
	
	
}
