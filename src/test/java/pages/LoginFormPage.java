package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends basePage {
	
	public LoginFormPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	public LoginFormPage digitarLogin(String login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
		
		return this;
	}
	public LoginFormPage digitarSenha(String password) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		
		return this;
	}
	public secretaPage clicarNoSignIn() {
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		return new secretaPage(navegador);
	}
	public secretaPage fazerLogin(String login, String password) {
		digitarLogin(login);
		digitarSenha(password);
		clicarNoSignIn(); 

		return new secretaPage(navegador);
	}
}
