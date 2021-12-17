import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametrizedTests {
	WebDriver driver;
    
    @BeforeAll
    public static void initialize() {
    	WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(2, TimeUnit.MINUTES);
    }
    

	@ParameterizedTest
    @ValueSource(strings = {
    		"AngularJS",
    		"Vue.js",
    		"React"})
    public void parametrizedTestTodoMvc(String platform) throws InterruptedException {
    	driver.get("https://todomvc.com");
 
    	TodoMvcObjects todoMvc = new TodoMvcObjects();
		Thread.sleep(3000);
		todoMvc.clickIntoTechnology(driver, platform);
		Thread.sleep(3000);
		System.out.println("ajout todo");		
		todoMvc.addTodo(driver, "Meet a Friend");
		todoMvc.addTodo(driver, "Buy Meat");
		todoMvc.addTodo(driver, "clean the car");
		
		System.out.println("remove todo");		
		todoMvc.remove(driver, 2);
		Thread.sleep(3000);
		todoMvc.verifyTodoList(driver, "2");

    	
    }
	
    
    
	@AfterEach
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }
}
