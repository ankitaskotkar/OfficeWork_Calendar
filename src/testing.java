import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testing {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akotkar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.findElement(By.cssSelector(".k-icon.k-i-calendar")).click();
		WebElement middle = driver.findElement(By.cssSelector("a[aria-live=\"assertive\"]"));
		WebElement next = driver.findElement(By.cssSelector("span.k-icon.k-i-arrow-60-right"));
		WebElement previous = driver.findElement(By.cssSelector("span.k-icon.k-i-arrow-60-left"));

		String date = "10/Jun/1992";

		String datearr[] = date.split("/");

		String day = datearr[0];
		String month = datearr[1];
		String year = datearr[2];

		int yearDifference = Integer.parseInt(year) - Calendar.getInstance().get(Calendar.YEAR);

		Thread.sleep(3000);

		middle.click();

		if (yearDifference != 0) {
			if (yearDifference > 0) {
				for (int i = 0; i < yearDifference; i++) {
					next.click();
				}
			} else {
				for (int i = 0; i < (yearDifference * (-1)); i++) {
					previous.click();
				}
			}
		}

		
		  Thread.sleep(3000);
		  
		  
		  List<WebElement> months= driver.findElements(By.cssSelector("table.k-content.k-meta-view.k-year>tbody>tr>td>a"));
		  
		  System.out.println(months.size());
		  
		  months.get(0).click();
		  
			/*
			 * for(int i=0;i<months.size();i++) {
			 * if(months.get(i).getAttribute("text")==month) { months.get(i).click(); break;
			 * }
			 * 
			 * }
			 */
		 
	}
}
