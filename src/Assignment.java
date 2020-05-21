import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main (String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
		driver.findElement(By.id("checkBoxOption3")).click();
		String text = driver.findElement(By.xpath("//label[@for='honda']")).getText().trim();
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		dropDown.click();
		Select s = new Select(dropDown);
		s.selectByVisibleText(text);
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(text))
			System.out.println("The alert box contains this text: "+ text);
		driver.quit();
	}
}
