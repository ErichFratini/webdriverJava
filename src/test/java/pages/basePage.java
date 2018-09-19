package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class basePage {
	protected WebDriver navegador;
	
	public basePage(WebDriver navegador) {
		this.navegador=navegador;
	}
	public String capturarTextoToast() {
		return navegador.findElement(By.id("toast-container")).getText();
		
	}
	
}