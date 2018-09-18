package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver navegador;
	
	public LoginPage(WebDriver navegador) {
		this.navegador = navegador;
	}
	public LoginFormPage clicarSignIn() {
		//Clicar no link que o texto sign in		
		/**WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
		linkSignIn.click();
		*/
		navegador.findElement(By.linkText("Sign in")).click();
		
		return new LoginFormPage(navegador);
				
	}
}
