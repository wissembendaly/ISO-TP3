import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TodoMvcObjects {

	public TodoMvcObjects() {
		super();
	}

	private By technologies = By.cssSelector(".js-app-list-inner.applist.js");
	private By todoInput = By.className("new-todo");
	private By todoNumber = By.cssSelector(".todo-count>strong");
	
	public void clickIntoTechnology(WebDriver driver,String name) {
		driver.findElement(this.technologies).findElement(By.linkText(name)).click();
	}
	
	public void addTodo(WebDriver driver,String todo) {
		driver.findElement(this.todoInput).sendKeys(todo);
		driver.findElement(this.todoInput).sendKeys(Keys.RETURN);
	}
	
	public void remove(WebDriver driver,int elementIndex) {
		driver.findElement(By.cssSelector("li:nth-child(" + elementIndex + ") > div > input")).click();
	}
	
	public void verifyTodoList(WebDriver driver, String number) {
		Assert.assertEquals(number, driver.findElement(this.todoNumber).getText());
		
	}
	
}
