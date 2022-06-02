import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class Ticket_ChaiCoffe2 {

	WebDriver driver;
	
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
			driver=new FirefoxDriver();
			driver.get("http://localhost:8080/application/");
			driver.manage().window().maximize();
		}
		@After
		public void tearDown() throws Exception {
			driver.close();
			driver.quit();
			
		}
	@Test
	public void test() {
		driver.findElememnt(By.id("firdtRadio")).click();
		
		WebElememt wb= driver.findElement(By.id("dCityDD"));
		Select s=new Select(wb);
		s.selectByVisibleText("Mysuru");
		
		WebElememt wb= driver.findElement(By.id("whereDD"));
		Select s=new Select(wb1);
		s.selectByVisibleText("VVMohalla");
		
		driver.findElement(By.id("homeDBtn")).click();
		
		driver.findElement(By.id("contactNumber")).sendKeys("9841777666");
		
		WebElememt table= driver.findElement(By.id("offersTable"));
		List<WebElement> rows=table.findElements(By.tagName("tr;"));
		int a=rows.size();
		for(int i=0;i<a;i++) {
			List<WebElement>cols=rows.get(i).findElement(By.tagName("td"));
			int b=cols.size();
			for(int j=0;j<b;j++) {
				String data=cols.get(j).getText();
				System.out.println(data);
				
			}
		}
		
		driver.findElement(By.id("tea")).click();
		
		WebElement w=driver.findElement(By.id("cupSize"));
		Select se=new Select(w);
		se.selectByVisibleText("Large");
		driver.findElement(By.id("rows")).sendKeys("6");
		driver.findElement(By.id("check1")).click();
		
		
		
	}

}
