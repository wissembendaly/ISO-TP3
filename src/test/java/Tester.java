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
	}

	
	@Test
	public void testerTodoMvc() throws InterruptedException {
		driver.get("https://todomvc.com/");
		Thread.sleep(3000);
		TodoMvcObjects todoMvc = new TodoMvcObjects();
		todoMvc.clickIntoTechnology(driver, "Backbone.js");
		
		Thread.sleep(3000);		
		System.out.println("ajout liste todo");		
		todoMvc.addTodo(driver, "Meet a Friend");
		todoMvc.addTodo(driver, "Buy Meat");
		todoMvc.addTodo(driver, "clean the car");
		
		System.out.println("remove todo");		
		todoMvc.remove(driver, 1);
		Thread.sleep(3000);
		System.out.println("verify todo liste");
		todoMvc.verifyTodoList(driver, "2");	
		System.out.println("end test");
	}
	

	@After
	public void afterTest() {
	
		driver.quit();
	}
	
	
}
