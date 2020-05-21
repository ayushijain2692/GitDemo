import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {
	
	public static void main(String args[]) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/");
	
	driver.findElement(By.xpath("//*[text()='Nested Frames']")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//driver.findElement(By.tagName("frameset"));
	driver.switchTo().frame(0);
	driver.switchTo().frame(1);
	System.out.println(driver.findElement(By.tagName("div")).getText());
	
	
	driver.quit();

}
}
