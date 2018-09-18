package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class secretaPage extends basePage{
	
	public secretaPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	public mePage clicarEmMe() {
		navegador.findElement(By.className("me")).click();
		
		return new mePage(navegador);
	}
}
