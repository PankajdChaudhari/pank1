import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

public class Selenium_java {
	
	webDriver driver=null;
	
	String url="http://localhost:8080/application/";
	@BeforeMethod
	
	

	@Test
	public void setUp() {
		System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
		driver=new cromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		

}
	
	
	@Test
	@Parameter({"contact","emailid","tickets"})
	public void test(@Optional("9876543210") String num,@Optional("john@gmail.com) String ma)"
			{
				driver.findElement(By.id("mom")).click();
				webaDriver dd1=driver.findElement(By.id("ListMom"));
				List<webElement> rows=dd1.findElements(By.tagName("tr"));
				System.out.println(rows.size());
				for(int i=1;i<=4;j++)
				{
					List<WebElement> cols=rows.get(i)findElements(By.tagName("td"));
					System.out.println(cols.get(0).getText()+""+cols.get(3).getText());
					
					
				}
				
				
				String msg=driver.findElement(By.xpath("/html/body/div[1]/p")).getText();
				if(msg.equals("click to check which movie is running in the malls"))
				{
					System.out.println("Its matches");
					
				}
				else
				{
					System.out.println("It does not matches");
				}
				
				driver.findElement(By.id("eventsLink")).click();
				
				driver.findElement(By.id("entk")).click();
				driver.findElement(By.id("book4")).click();
				driver.switchzto().alert().accept();
				driver.switchTo().frame("left");
				
				softAssert as=new softAssert();
				String msg2=driver.finfElement(By.id("calculatefare")).getText();
				as.assertEquals(ms2,"calculate Cost");
			driver.findElement(By.id("phone")).sendKeys("num");
			driver.findElement(By.id("email")).sendKeys("maill");
			driver.findElement(By.id("tichetNo")).sendKeys("Ticket");
			driver.findElement(By.id("chechValid")).click();
			
			driver.findElement(By.id("calculateFare")).click();
			
			String msg3=driver.switchTo.alert().getText()
					System.out.println(msg3);
			
			
			
					
				}
			}

@AfterMethod
public void tearDown() {
	driver.quit();
	driver.close();
}
}
