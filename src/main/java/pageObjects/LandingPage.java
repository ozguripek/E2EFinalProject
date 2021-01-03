package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By signin = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");

	public WebElement getLogin() {
		return driver.findElement(signin);

	}

	private By title = By.cssSelector(".text-center>h2");
	// //h2[text()='Featured Courses']

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	private By navBar = By.cssSelector("div>nav>ul>li:nth-child(8)>a");
	//By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");	

	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
}
