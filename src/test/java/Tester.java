import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.*;


public class Tester {

	WebDriver driver;
	
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
 
		
	}

	
	@Test
	public void testerTodoMvc() throws InterruptedException {
		driver.get("https://todomvc.com/");
	
		Thread.sleep(3000);
		TodoMvcObjects todoMvc = new TodoMvcObjects();
		System.out.println("ajout todo");		
		Thread.sleep(3000);
		todoMvc.clickIntoTechnology(driver, "Backbone.js");
		Thread.sleep(3000);
		
		todoMvc.addTodo(driver, "Meet a Friend");
		todoMvc.addTodo(driver, "Buy Meat");
		todoMvc.addTodo(driver, "clean the car");
		
		System.out.println("check todo");		
		Thread.sleep(3000);
		todoMvc.checkTodo(driver, "1");
		Thread.sleep(3000);

		
	}
	

	@After
	public void afterTest() {
	
		driver.quit();
	}
	
	
}
