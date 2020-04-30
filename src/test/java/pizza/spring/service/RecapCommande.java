package pizza.spring.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecapCommande {
	private WebDriver webDriver;
	
	public RecapCommande(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public boolean isValid() {
		return webDriver.findElement(By.id("recap-commande")).isDisplayed();
	}
}
