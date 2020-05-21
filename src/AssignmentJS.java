import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentJS {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		String expectedText="United States";
		String actualText = " ";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		int count=0;
		
		while(!(actualText.contains(expectedText))) {
			if(count<10) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			Thread.sleep(2000);
			actualText = (String)js.executeScript(script);
			
			
					count++;
		}else break;
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Ayushi\\screenshot.png"));
		if(count<10)
		System.out.println("Element found with text : " + actualText);
		else
			System.out.println("Element not found");
		
		driver.quit();
	}

}
