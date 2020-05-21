import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentTables {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohan\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		List<WebElement> rows = driver.findElements(By.cssSelector("table[id='product'] tbody tr"));
		int rowCount = rows.size();
		System.out.println("No. of rows in the table are: "+rowCount);
		
		int columnCount = table.findElements(By.cssSelector("table[id='product'] tbody tr th")).size();
		System.out.println("No. of columns in the table are: "+columnCount);
		
		for (int i=0; i<rowCount; i++) {
			if(i==2) {
				List<WebElement> columns= rows.get(i).findElements(By.cssSelector("table[id='product'] tbody td"));
				for(int j=0; j<columnCount;j++) {
				System.out.println(columns.get(j).getText());
						}
		}
		
		}		
driver.quit();
	}
}