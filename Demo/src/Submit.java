import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.testng.annotations.Test;


public class Submit {

	@BeforeClass

	public void setUp() {
	System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
			
	driver=new FirefoxDriver();
	driver.get("http://localhost:8080/application/");
	driver.manage().timeouts().implicitlywait(12,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	@Test
	public void test() throws IOException {
		driver.findElement(By.id("bmhm")).click();
		File scr1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scr1,new File("/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSupplies"));
		  
		  driver.findElement(By.id("offerLink")).click();
		  WebElement form=driver.findElement(By,id("offersDropdown"));
		  Select f=new Select(form);
		  f.selectByIndex(1);
		  System.out.println("f");
		  
		  driver.findElement(By.id("eventsLink")).click();
		  driver.findElement(By.id("ent")).isSelected();
		  
		  WebElement movies=driver.findElement(By.id("eventsTable"));
		  List<WebElement> rows=movies.findElements(By.tagName("tr"));
		  System.out.println(cols.get(0).getText()+""+cols.get(1).getText());
		  
	}
	
	driver.findElement(By.id("book2")).click();
	driver.findElement(By.id("book2")).click();
	String msg=driver.switchTo().alert().getText();
	System.out.println(msg);
	driver.switchTo().alert().accept();
	
	Assert.assertEquals(msg,"You will be moved to booking page now");
	
	Set<String>WindowHandles=driver.getWindowHandles();
	System.out.println("Number of opened windows:"+Windowhandles.size());
	for (String handle:windowhandles) {
		driver,switchTo().window(handle);
		string url=driver.getCurrentUrl();
		System.out.println(url);
		
	
	if(url.equals("http://localhost:8080/a[pplication.movies.html")) {
		System.out.println("Desired window found");
	}
	else {
		System.out.println("Desired window is not found");
		
	}
	
	String path="/html/user/Desktop/user_repo/To_Participant/AdditionalSupplies";
	 FileInputStream fs=new FileInputStream(path);
	  HSSFWokbook wb=new HSSFWorkbook(fis);
	  HSSFSheet sh1= wb.getSheet("Details");
	  int rowcount=sh1.getLastRowNum()-sh1.getFirstRowNum();
	  for(int i=1;i<=rowcount;i++) {
		  
		  driver.findElement(By.id("phone")).sendKeys(sh1.getRowe(1).getcell());
		  driver.findElement(By.id("email")).sendKeys(sh1.getRowe(1).getcell());
		  driver.findElement(By.id("ticketNo")).sendKeys(sh1.getRowe(1).getcell());
		  
		  driver.findElement(By.id("checkValid")).click();
		  driver.findElement(By.id("calculateFare")).click();
		  driver.switchTo().alert().accept();
		  
	  }
	  
	  @AfterClass
		public void tearDown() {
			driver.close();
			driver.quit();
		}
		
	

	}


