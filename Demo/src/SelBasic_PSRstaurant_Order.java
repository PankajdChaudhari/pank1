import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.asserts.SoftAssert;


public class SelBasic_PSRstaurant_Order {
WebDriver driver;

String url="http://localhost:8080/application/";
@BeforeClass

public void setUp() {
	System.setProperty("webdiver.gecko.driver", "/home/user/Desktop/geckodriver");
	driver=new FirefoxDriver();
	
	driver.get("http://localhost:8080/application/");
	
	driver.manage().timeouts().implicitlywait(12,TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(5000);
	
}

@Test
public void process() {
	driver.findElement(By.id("Order Now")).click();
	driver.switchTo().frame("left");
	String title=driver.get.title();
	SoftAssert s=new SoftAssert();
	sa.assertEquals(title,"Bootstrap Example");
	System.out.println("Success");
	driver.findElement(By.id("Vegeterian")).click();
	
	for(int i=0; i<=4; i++) {
		WebElement name=new driver.findElement(By.id("Dropdown"));
		Select n=new Select(name);
		n.SelectByIndex(i);
		
	}
	
	driver.findElement(By.id("Take Away")).click();
	String path="/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSupplies";
	
	FileInputStream fis=new FileInputStream("/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSuppliedFiles/Order.xls");
	
	  HSSFWokbook wb=new HSSFWorkbook(fis);
	  HSSFSheet sh1= wb.getSheet("Data");
	  
	  int rowCount=sh1.getLastRowNum()-sh1.getFirstRowNum();
		driver.findElement(By.id("Vegitarian")).click();
	  
		for(int i=0; i<=rowCount; i++) {
		Double mobile=sh1.getRow(i).getCell(3).getNumberCellValue();
		String mobileno=String.valueOf(mobile);
		Thread.sleep(1000);
		
		WebElement dish=driver.findElement(By.id("Main Dish"));
		Select t=new Select(dish);
		t.selectByIndex(2);
		Thread.sleep(1000);
		
		WebElement Curry=driver.findElement(By.id("Curry"));
		Select t=new Select(Curry);
		t.selectByIndex(1);
		Thread.sleep(1000);
		
		driver.findElement(By.id("Mobile Number")).sendKeys(mobileno);
		driver.findElement(By.id("Submit")).click();
		String msg2=driver.switchTo().alert().getText();
		System.out.println(msg2);
		
		FileOutpurStream fs=new FileOutputStream(msg2);
		
		
		
		}
		
		List<WebElement> links=driver.findElement(By.tagName("a"));
		System.out.println(links);
		String path2=driver.findElement(By(id("Home Delivery"))).getText();
		if(path2.equals("Home Delivery")) {
			System.out.println("Home delivery link is available");
			
		}
		else {
			System.out.println("Home deliveery link is not available");
		}
		
		driver.findElement(By.linkText("Weekend offr link")).click();
		
		WebElement dd2=driver.findElement(By.id("Upcoming  table.."));
		
		
		List<WebElement> row=dd2.findElements(by.tagName("tr"));
		for(int i=0; i<=3; i++) {
			List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
			System.out.println(col.get(1).getText());
		}
		
		driver.findElement(By.id("Gallary")).click();
		 File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scr1,new File("Desktop\\Gallary.png","/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSuppliedFiles"));
				
		
	
}



@AfterClass
public void tearDown() {
	driver.close();
	driver.quit();
}
}