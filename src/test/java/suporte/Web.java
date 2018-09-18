package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver createChrome() {
		//Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Inmetrics\\Downloads\\chromedriver_win32\\chromedriver.exe");
        
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\erich\\drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5	, TimeUnit.SECONDS);
		
		//Navegando para alguma pagina
		navegador.get("http://www.juliodelima.com.br/taskit/");	
		return navegador;
	}
}
