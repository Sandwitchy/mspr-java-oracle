package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Commande {

	private WebDriver webDriver;

	public Commande(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Commande open() {
		webDriver.get("http://localhost:8080/pizza-spring-0.0.1-SNAPSHOT/commande");
		assertTrue(webDriver.getTitle(), webDriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}

	public Commande selectPizza() {
		WebElement selectElement = this.webDriver.findElement(By.id("pizzaId"));
		Select select = new Select(selectElement);
		select.selectByValue("1");
		return this;
	}
	public static Commande openWith(WebDriver webDriver) {
	    Commande commande = new Commande(webDriver);
	    commande.open();
	    return commande;
    }
	public Commande enterName() {
		this.webDriver.findElement(By.id("nom")).sendKeys("Dupont");
		return this;
	}
	public Commande enterTelephone() {
		this.webDriver.findElement(By.id("telephone")).sendKeys("0613903316");
		return this;
	}

	public boolean checkPizzaError() {
		return this.webDriver.findElement(By.id("pizzaId.errors")).isDisplayed();			
	}
	
	public boolean checkTelephoneError() {
		return this.webDriver.findElement(By.id("telephone.errors")).isDisplayed();
	}
	public RecapCommande send() {
		WebElement searchButton = webDriver.findElement(By.cssSelector("button[type='submit']"));
	    searchButton.click();
		return new RecapCommande(webDriver);
	}
}
