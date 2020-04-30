package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommandeAcceptanceTest {

	private WebDriver webDriver;
	
	@Before
	public void createWebDriver() {
		this.webDriver = new ChromeDriver();
	}
	
	@After
	public void closeWebDriver() {
		webDriver.quit();
	}
	
	@Test
	public void checkCommandeSuccess() {
		Commande commande = Commande.openWith(webDriver);
		
		commande.selectPizza().enterName().enterTelephone();
		RecapCommande recap = commande.send();
		
		assertTrue(recap.isValid());
	}
	
	@Test
	public void checkCommandeFailedWithNoPizzaSelected() {
		Commande commande = Commande.openWith(webDriver);
		
		commande.enterName().enterTelephone();
		RecapCommande recap = commande.send();
		
		assertTrue(commande.checkPizzaError());
	}
	
	@Test
	public void checkCommandeFailedWithNoTelephone() {
		Commande commande = Commande.openWith(webDriver);
		
		commande.selectPizza().enterName();
		RecapCommande recap = commande.send();
		
		assertTrue(commande.checkTelephoneError());
	}
}
