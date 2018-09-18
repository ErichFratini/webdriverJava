package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mePage extends basePage {

	public mePage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}
	public mePage clicarAbaMoreDataAbout(){
		navegador .findElement(By.linkText("MORE DATA ABOUT YOU")).click();

		return this;
	}
	public AddContactPage clicarBotaoAddMoreDataAbout() {
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		return new AddContactPage(navegador) ;
	}
}
