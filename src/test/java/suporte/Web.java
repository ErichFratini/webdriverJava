package suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	
	  public static final String USERNAME = "erichalvesfratin1";
	  public static final String AUTOMATE_KEY = "GCDApvpeTkwyedD9wQxM";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
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
	public static WebDriver createBrowserStack() {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "69.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1280x1024");

		    WebDriver navegador = null;
		    try {
		    navegador = new RemoteWebDriver(new URL(URL), caps);
		    navegador.manage().timeouts().implicitlyWait(5	, TimeUnit.SECONDS);
			
			
			navegador.get("http://www.juliodelima.com.br/taskit/");	
		    }catch(MalformedURLException e){
		    	System.out.println("Houveram problemas com a URL"+e.getMessage());
		    }
		    
		    
		    return navegador;
	}
}	

