import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalProgram {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akotkar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.findElement(By.cssSelector(".k-icon.k-i-calendar")).click();
		WebElement middle = driver.findElement(By.cssSelector("a[aria-live=\"assertive\"]"));
		WebElement next = driver.findElement(By.cssSelector("span.k-icon.k-i-arrow-60-right"));
		WebElement previous = driver.findElement(By.cssSelector("span.k-icon.k-i-arrow-60-left"));

		String date = "32/Jul/1992";

		String datearr[] = date.split("/");

		String day = datearr[0];
		String month = datearr[1];
		String year = datearr[2];

		int yearDifference = Integer.parseInt(year) - Calendar.getInstance().get(Calendar.YEAR);

		Thread.sleep(3000);
		
		//select year
		middle.click();

		if (yearDifference != 0) {
			if (yearDifference > 0) {
				for (int i = 0; i < yearDifference; i++) {
					//Thread.sleep(1000);
					next.click();
				}
			} else {
				for (int i = 0; i < (yearDifference * (-1)); i++) {
					//Thread.sleep(1000);
					previous.click();
				}
			}
		}

		
		  Thread.sleep(3000);
		  
		  //select month
		  List<WebElement> months= driver.findElements(By.cssSelector("table.k-content.k-meta-view.k-year>tbody>tr>td>a"));
		  
		  System.out.println(months.size());
	
		  for(int i=0;i<months.size();i++) {
			  if(months.get(i).getAttribute("text").equalsIgnoreCase(month)) { 
				  months.get(i).click(); 
				  break;
			  }
		  }
		  
		
		  //select day		  
		  List<WebElement> dates= driver.findElements(By.cssSelector("table.k-content.k-month>tbody>tr>td:not(.k-other-month)>a"));
		  
		  System.out.println(dates.size());
		  
		  for(int i=0;i<dates.size();i++) {
			  if(dates.get(i).getAttribute("text").equalsIgnoreCase(day)) { 
				  dates.get(i).click(); 
				  break;
			  }	  
		  }
				  			 
		  
		  //another method to select month same we trace table
		/*	  
		  String beforeXpath="//table[@tabindex='0']//tbody//tr[";
		  String afterXpath="]//td[";
				  
	      for(int rowNum=1;rowNum<=3;rowNum++) {
	    	  for(int colNum=1;colNum<=4;colNum++) {
	    		  
	    		  WebElement monthElement=driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]"));
	    		  
	    		  String monthValue=monthElement.getText();
	    		  System.out.println(monthValue);
	    		  if(monthValue.equalsIgnoreCase(month)) {
	    			  monthElement.click();
	    			  break;
	    		  }
	    	  }
	      }
	      
	      //another method to select day same as we trace the table
	      
		  String daysbeforeXpath="//table[@tabindex='0']//tbody//tr[";
		  String daysafterXpath="]//td[@class='' or @class='k-weekend'][";
				  
	     BB: for(int rowNum=1;rowNum<=6;rowNum++) {
	    	  for(int colNum=1;colNum<=7;colNum++) {
	    		  
	    		  WebElement dayElement=driver.findElement(By.xpath(daysbeforeXpath+rowNum+daysafterXpath+colNum+"]"));
	    		 
	    		  String dayValue=dayElement.getText();
	    		  System.out.println(dayValue);
	    		  if(dayValue.equalsIgnoreCase(day)) {
	    			  dayElement.click();
	    			  break BB;
	    		  }
	    	  }
	      }*/
	}
}
