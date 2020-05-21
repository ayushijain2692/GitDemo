import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		String expectedText = "MON";
		String actualText = new String();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		int counter=0;
		System.out.println("Learning Git and GitHub");
		
		while(!(actualText.contains(expectedText))) {
			if(counter <=10) {
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			Thread.sleep(2000);
			actualText= (String) js.executeScript("return document.getElementById(\"fromPlaceName\").value;");
				counter++;
			}else break;
	}
		
	System.out.println(actualText);	
	driver.quit();
	}

}
