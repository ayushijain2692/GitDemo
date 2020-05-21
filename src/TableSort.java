import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.xpath("//*[text()='Top Deals']")).click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		int rowCount = rows.size();
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> sortedList = new ArrayList<String>();
		
		for (int i=1; i<=rowCount; i++) {
				String value = driver.findElement(By.xpath("(//tbody/tr/td[2])["+i+"]")).getText();
				System.out.println(value);
				originalList.add(value);
						
		}
			
		
		for (int i=0; i<originalList.size(); i++) {
			sortedList.add(originalList.get(i));
			
		}
		System.out.println(" Before Sorting the list....");
		System.out.println(originalList);
		System.out.println(sortedList);
		System.out.println(" After Sorting the list....");
		Collections.sort(sortedList);
		System.out.println(sortedList);
		Assert.assertFalse(sortedList.equals(originalList));
		System.out.println(" After Sorting the list in descending....");
		Collections.reverse(sortedList);
		System.out.println(sortedList);
		

driver.quit();
	}

}
