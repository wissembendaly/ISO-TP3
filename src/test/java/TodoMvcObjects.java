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
	private By listTodo = By.className("todo-list");
	private By todoNumber = By.cssSelector(".todo-count>strong");
	
	public void clickIntoTechnology(WebDriver driver,String name) {
		driver.findElement(this.technologies).findElement(By.linkText(name)).click();
	}
	
	public void addTodo(WebDriver driver,String todo) {
		driver.findElement(this.todoInput).sendKeys(todo);
		driver.findElement(this.todoInput).sendKeys(Keys.RETURN);
	}
	
	public void checkTodo(WebDriver driver,String todo) {
		driver.findElement(this.listTodo).findElement(By.linkText(todo)).findElement(By.xpath("//parent::div/input")).click();
	}
	
	public void verifyTodoList(WebDriver driver, String number) {
		Assert.assertEquals("Pas de compte ? Créez-en un", driver.findElement(this.todoNumber).getText());
		
	}
	
}
