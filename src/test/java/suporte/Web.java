package suporte;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	//por enquanto essas linhas não vão fazer sentido, mas basicamente é aqui que é setado as credenciais para acessar o BrowserStack e executar os testes e um servidor
	  public static final String USERNAME = "erichalvesfratin1";
	  public static final String AUTOMATE_KEY = "GCDApvpeTkwyedD9wQxM";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
	public static WebDriver createChrome() {
		//Nessa linha é chamado e executado chromedriver.exe, esse caminho aqui especificado deve ser mudado de acordo com a maquina, tente manter sempre o chrome e o chrome driver atuaalizados.
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Inmetrics\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\erich\\drivers\\chromedriver.exe");
        //Aqui chamamos de fato o chorme a ser aberto
		WebDriver navegador = new ChromeDriver();
		//para melhor vizualização maximize a tela com esse codigo, mas não é necessario
		navegador.manage().window().maximize();
		//aqui utilizamos um tempo implicito de 5 segundos para aguardar carregamento de tela
		navegador.manage().timeouts().implicitlyWait(5	, TimeUnit.SECONDS);
		
		//para navegarmos pelas telas  usamos o .get depois da variavel navegador e como paremtro, obviamente o site que voce deseja testar
		navegador.get("http://www.juliodelima.com.br/taskit/");	
		//como ainda estmos em um metodo que não é void, então retornamos a variavel navegadorque nesse momento ja está no site aguardando as instruçoes
		return navegador;
		//agora volte para a classe InformacoesUsuarioTest
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

