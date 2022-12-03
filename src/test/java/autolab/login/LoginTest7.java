package autolab.login;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest7 {
	private WebDriver driver;
	private String URL_BASE = "http://127.0.0.1:5500/login.html";//https://www.google.com
	private String PATH_DRIVE = "src\\test\\resources\\chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void loginCorreto() {
		//Montagem do cenário
		iniciar();
		
		//preparação
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement btnEntrar = driver.findElement(By.id("btn-entrar"));
		
		inputEmail.sendKeys("admin@admin.com");
		inputSenha.sendKeys("admin@123");
		btnEntrar.sendKeys(Keys.ENTER);
		
		String resultado = driver.findElement(By.id("mensagem")).getText();
		System.out.println(resultado);
		
		//Verificação
		assertTrue(resultado, resultado.contains(""));
	}
	
}

