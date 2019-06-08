package com.machava.demo.trelloapiwithselenium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloApiWithSeleniumApplicationTests {

	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void setup() {
		String pathToGeckoDrive = "/home/vergil333/IdeaProjects/trello-api-with-selenium/geckodriver"; // Change to match your path
		System.setProperty("webdriver.gecko.driver", pathToGeckoDrive);
		driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, 7);
	}

	@Test
	public void startMainTest() throws InterruptedException {
		login();

		openBoard();

		archiveAllLists();

		createDemoListAndCard();

		driver.close();
	}

	private void login() {
		driver.get("https://trello.com/login");
		if (driver.findElements(By.id("user-password")).size() > 0) {
			driver.findElement(By.id("user-password")).click();
		}

		driver.findElement(By.id("user")).sendKeys("mojtestovaciucet1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("BOnubsIldAdHoa6");
		driver.findElement(By.id("login")).submit();
	}

	private void openBoard() {
		// Make sure we are on board menu
		WebElement boardHref = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/martinmachava3/boards']")));
		if (!boardHref.getAttribute("class").equals("_3C9rwrEaxzhr8w _1gsiCYfUL0OjDP")) {  // if not highlighted
			boardHref.click();
		}

		// Open Demo Board
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='board-tile-details-name']//div[text()='Demo board']"))).click();

		// Wait for Demo Board to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='board-wrapper']")));
	}

	private void archiveAllLists() {
		List<WebElement> listMenus = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='list-header-extras']")));
		int elementSize = listMenus.size();
		listMenus.forEach(this::archiveList);

		// Make sure to remove even lists that are not visible in window
		if (elementSize >= 5) {
			archiveAllLists();
		}
	}

	private void archiveList(WebElement element) {
		element.click();
		driver.findElement(By.xpath("//a[@class='js-close-list'][text()='Archive This List']")).click();
	}

	private void createDemoListAndCard() {
		createDemoList();
		createDemoCard();
	}

	private void createDemoList() {
		driver.findElement(By.xpath("//a[@class='open-add-list js-open-add-list']//span[@class='placeholder']"))
				.click();

		driver.findElement(By.xpath("//input[@class='list-name-input']"))
				.sendKeys("Demo List");

		driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"))
				.click();
	}

	private void createDemoCard() {
		driver.findElement(By.xpath("//a[@class='open-card-composer js-open-card-composer']"))
				.click();

		driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"))
				.sendKeys("Demo Card");

		driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"))
				.click();
	}

}
